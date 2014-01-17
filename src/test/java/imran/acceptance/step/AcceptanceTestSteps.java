package imran.acceptance.step;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import imran.RockPaperScissors;
import imran.context.ApplicationContext;
import imran.error.GameException;
import imran.factory.mode.GameModeProvider;
import imran.factory.move.InteractiveMoveProvider;
import imran.factory.move.MoveProviderFactory;
import imran.factory.move.RandomizedMoveProvider;
import imran.model.rules.RockPaperScissorsRules;
import imran.model.rules.Rules;
import imran.representation.result.Result;
import imran.service.Game;
import imran.service.RockPaperScissorsGame;

import java.util.List;
import java.util.Map;

import static com.google.common.collect.Maps.newHashMap;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import static imran.context.ApplicationContext.getInstance;

public class AcceptanceTestSteps {

    private static Map<String, String> PLAYER_MOVES = newHashMap();
    private static Map<String, Integer> COMPUTER_MOVES = newHashMap();

    static {
        PLAYER_MOVES.put("Rock", "1");
        PLAYER_MOVES.put("Paper", "2");
        PLAYER_MOVES.put("Scissors", "3");
        COMPUTER_MOVES.put("Rock", 0);
        COMPUTER_MOVES.put("Paper", 1);
        COMPUTER_MOVES.put("Scissors", 2);
    }

    private RockPaperScissors rockPaperScissors;
    private MockInteractiveConsole console;
    private MockRandomNumberGenerator generator;

    private List<String> playerMoves;
    private List<String> computerMoves;
    private List<String> computer1Moves;
    private List<String> computer2Moves;
    private String selectedInvalidOption;

    public AcceptanceTestSteps() {
        console = new MockInteractiveConsole();
        generator = new MockRandomNumberGenerator();
    }

    @Given("^rock, paper, scissors game app is running")
    public void instantiateRockPaperScissors() throws Throwable {
        ApplicationContext applicationContext = getInstance();
        applicationContext.setInteractiveConsole(console);
        applicationContext.setRandomNumberGenerator(generator);
        ((GameModeProvider)applicationContext.getBean(GameModeProvider.class)).setApplicationContext(applicationContext);
        ((MoveProviderFactory)applicationContext.getBean(MoveProviderFactory.class)).setApplicationContext(applicationContext);
        ((InteractiveMoveProvider)applicationContext.getBean(InteractiveMoveProvider.class)).setApplicationContext(applicationContext);
        ((RandomizedMoveProvider)applicationContext.getBean(RandomizedMoveProvider.class)).setApplicationContext(applicationContext);
        ((RockPaperScissorsGame)applicationContext.getBean(Game.class)).setApplicationContext(applicationContext);
        ((RockPaperScissorsRules)applicationContext.getBean(Rules.class)).setApplicationContext(applicationContext);
        rockPaperScissors = new RockPaperScissors(applicationContext);
    }

    @When("^I choose to play Computer against the Computer")
    public void setGameModeForComputerVsComputer() throws Throwable {
        rockPaperScissors.whenYouSelectAGameMode("2");
    }

    @When("^I choose to play as a Player against the Computer")
    public void setGameModeForPlayerVsComputer() throws Throwable {
        rockPaperScissors.whenYouSelectAGameMode("1");
    }

    @When("^I choose option \"([^\"]*)\" as game mode$")
    public void selectAnInvalidGameModeOption(String gameModeOprion) {
        this.selectedInvalidOption = gameModeOprion;
    }

    @And("^when I make the following moves:$")
    public void setPlayerMoves(List<String> playerMoves) throws Throwable {
        this.playerMoves = playerMoves;
    }

    @And("^when Computer makes the following moves against my moves:$")
    public void setComputerMoves(List<String> computerMoves) throws Throwable {
        this.computerMoves = computerMoves;
    }

    @And("^when Computer-1 makes the following moves:$")
    public void setComputer1Moves(List<String> computerMoves) throws Throwable {
        this.computer1Moves = computerMoves;
    }

    @And("^when Computer-2 makes the following moves against Computer-1 moves:$")
    public void setComputer2Moves(List<String> computerMoves) throws Throwable {
        this.computer2Moves = computerMoves;
    }

    @And("^I choose option \"([^\"]*)\" as a move$")
    public void selectAnInvalidMoveOption(String move) {
        this.selectedInvalidOption = move;
    }

    @Then("^the outcome of Player vs Computer game is:$")
    public void shouldReturnPlayerVsComputerGameResult(List<String> outcome) throws Throwable {
        for (int i=0; i<outcome.size(); i++) {
            console.setMoveChoice(PLAYER_MOVES.get(playerMoves.get(i)));
            generator.setMoveChoice(COMPUTER_MOVES.get(computerMoves.get(i)));
            Result result = rockPaperScissors.andFirstPlayerMakesAMove().andSecondPlayerMakesAMove().andGameStarts();

            assertThat(result.toString(), is(equalTo(outcome.get(i))));
        }
    }

    @Then("^the outcome of Computer-1 vs Computer-2 game is:$")
    public void shouldReturnComputer1VsComputer2GameResult(List<String> outcome) throws Throwable {
        for (int i=0; i<outcome.size(); i++) {
            generator.setMoveChoice(COMPUTER_MOVES.get(computer1Moves.get(i)));
            rockPaperScissors.andFirstPlayerMakesAMove();
            generator.setMoveChoice(COMPUTER_MOVES.get(computer2Moves.get(i)));
            Result result = rockPaperScissors.andSecondPlayerMakesAMove().andGameStarts();

            assertThat(result.toString(), is(equalTo(outcome.get(i))));
        }
    }

    @Then("^I see the error message \"([^\"]*)\" for selected game mode$")
    public void assertGameModeError(String errorMessage) {
        try {
            rockPaperScissors.whenYouSelectAGameMode(selectedInvalidOption);
        }
        catch (GameException e) {
            assertThat(e.getMessage(), is(equalTo(errorMessage)));
        }
    }

    @Then("^I see the error message \"([^\"]*)\" for selected move$")
    public void assertMoveError(String errorMessage) {
        try {
            console.setMoveChoice(selectedInvalidOption);
            generator.setMoveChoice(COMPUTER_MOVES.get("Rock"));
            rockPaperScissors.andFirstPlayerMakesAMove().andSecondPlayerMakesAMove().andGameStarts();
        }
        catch (GameException e) {
            assertThat(e.getMessage(), is(equalTo(errorMessage)));
        }
    }
}