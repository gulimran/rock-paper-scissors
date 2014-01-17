package imran;

import imran.context.ApplicationContext;
import imran.error.GameException;
import imran.factory.move.InteractiveMoveProvider;
import imran.factory.move.RandomizedMoveProvider;
import imran.model.rules.RockPaperScissorsRules;
import imran.model.rules.Rules;
import imran.representation.mode.GameMode;
import imran.factory.mode.GameModeProvider;
import imran.representation.move.Move;
import imran.factory.move.MoveProvider;
import imran.factory.move.MoveProviderFactory;
import imran.model.player.Player;
import imran.model.player.PlayerType;
import imran.model.player.RockPaperScissorsPlayer;
import imran.representation.result.Result;
import imran.service.Game;
import imran.service.RockPaperScissorsGame;
import imran.view.InteractiveConsole;

import static imran.context.ApplicationContext.getInstance;
import static imran.util.StringUtil.*;

public class RockPaperScissors {

    public static void main(String[] args) {
        RockPaperScissors game = new RockPaperScissors(getInstance());
        String choice;

        do {
            choice = game.interactiveConsole.getMainMenuChoice();

            if (isBlank(choice)) break;

            try {
                Result result = game.whenYouSelectAGameMode(choice)
                                    .andFirstPlayerMakesAMove()
                                    .andSecondPlayerMakesAMove()
                                    .andGameStarts();

                game.thenYouSeeTheGameResult(result);
            }
            catch (GameException e) {
                game.thenYouSeeTheError(e.getMessage());
            }
        }
        while (isNotBlank(choice));

        System.exit(0);
    }

    public RockPaperScissors whenYouSelectAGameMode(String gameModeChoice) {
        gameMode = gameModeProvider.getGameMode(gameModeChoice);
        return this;
    }

    public RockPaperScissors andFirstPlayerMakesAMove() {
        PlayerType firstPlayerType = gameMode.getFirstPlayerType();
        String firstPlayerName = gameMode.getFirstPlayerName();
        MoveProvider firstPlayerMoveProvider = moveProviderFactory.getMoveProvider(firstPlayerType);
        Move firstPlayerMove = firstPlayerMoveProvider.getMove();
        firstPlayer = new RockPaperScissorsPlayer(firstPlayerName, firstPlayerMove);
        return this;
    }

    public RockPaperScissors andSecondPlayerMakesAMove() {
        PlayerType secondPlayerType = gameMode.getSecondPlayerType();
        String secondPlayerName = gameMode.getSecondPlayerName();
        MoveProvider secondPlayerMoveProvider = moveProviderFactory.getMoveProvider(secondPlayerType);
        Move secondPlayerMove = secondPlayerMoveProvider.getMove();
        secondPlayer = new RockPaperScissorsPlayer(secondPlayerName, secondPlayerMove);
        return this;
    }

    public Result andGameStarts() {
        return rockPaperScissorsGame.play(firstPlayer, secondPlayer);
    }

    public void thenYouSeeTheGameResult(Result result) {
        interactiveConsole.displayResult(result);
    }

    public void thenYouSeeTheError(String message) {
        interactiveConsole.displayError(message);
    }

    public RockPaperScissors(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
        this.rockPaperScissorsGame = (Game) applicationContext.getBean(Game.class);
        this.interactiveConsole = (InteractiveConsole) applicationContext.getBean(InteractiveConsole.class);
        this.gameModeProvider = (GameModeProvider) applicationContext.getBean(GameModeProvider.class);
        this.gameModeProvider.setApplicationContext(applicationContext);
        this.moveProviderFactory = (MoveProviderFactory) applicationContext.getBean(MoveProviderFactory.class);
        this.moveProviderFactory.setApplicationContext(applicationContext);
        ((InteractiveMoveProvider)applicationContext.getBean(InteractiveMoveProvider.class)).setApplicationContext(applicationContext);
        ((RandomizedMoveProvider)applicationContext.getBean(RandomizedMoveProvider.class)).setApplicationContext(applicationContext);
        ((RockPaperScissorsGame)applicationContext.getBean(Game.class)).setApplicationContext(applicationContext);
        ((RockPaperScissorsRules)applicationContext.getBean(Rules.class)).setApplicationContext(applicationContext);
    }

    private final ApplicationContext applicationContext;
    private final InteractiveConsole interactiveConsole;
    private final Game rockPaperScissorsGame;
    private final GameModeProvider gameModeProvider;
    private final MoveProviderFactory moveProviderFactory;

    private GameMode gameMode;
    private Player firstPlayer;
    private Player secondPlayer;
}
