package imran.service;

import imran.context.ApplicationContext;
import imran.model.rules.*;
import imran.representation.move.Move;
import imran.model.player.Player;
import imran.representation.result.Outcome;
import imran.representation.result.Reason;
import imran.representation.result.Result;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;

import static imran.representation.move.Move.*;
import static imran.representation.result.Outcome.*;
import static imran.representation.result.Reason.*;
import static imran.context.ApplicationContext.getInstance;

@RunWith(MockitoJUnitRunner.class)
public class RockPaperScissorsGameTest {

    private static final String NEW_LINE = System.getProperty("line.separator");

    private RockPaperScissorsGame game;

    @Mock
    private Player firstPlayer, secondPlayer;

    @Before
    public void setup() {
        ApplicationContext applicationContext = getInstance();
        RockPaperScissorsRules rockPaperScissorsRules = (RockPaperScissorsRules) applicationContext.getBean(Rules.class);
        rockPaperScissorsRules.setApplicationContext(applicationContext);
        game = (RockPaperScissorsGame) applicationContext.getBean(Game.class);
        game.setApplicationContext(getInstance());
    }

    @Test
    public void playerShouldWin_WhenPlayerThrowsRockAndComputerThrowsScissors() {
        assertThatTestResultHasGivenOutcomeAndReason(
                forGivenPlayerVsComputerModeAndForGivenMoves(ROCK, SCISSORS), WIN, ROCK_BEATS_SCISSORS);
    }

    @Test
    public void computerShouldWin_WhenComputerThrowsPaperAndComputerThrowsRock() {
        assertThatTestResultHasGivenOutcomeAndReason(
                forGivenComputerVsComputerModeAndForGivenMoves(PAPER, ROCK), WIN, PAPER_BEATS_ROCK);
    }

    @Test
    public void testResultToString() {
        // given
        String expected = "Computer1 played PAPER. Computer2 played ROCK. Paper beats Rock. Computer1 wins.";
        given(firstPlayer.getName()).willReturn("Computer1");
        given(secondPlayer.getName()).willReturn("Computer2");

        // when
        Result result = forGivenComputerVsComputerModeAndForGivenMoves(PAPER, ROCK);

        // then
        assertThat(result.toString(), is(equalTo(expected)));
    }

    private Result forGivenPlayerVsComputerModeAndForGivenMoves(Move firstPlayerMove, Move secondPlayerMove) {
        forGivenMoves(firstPlayerMove, secondPlayerMove);
        return game.play(firstPlayer, secondPlayer);
    }

    private Result forGivenComputerVsComputerModeAndForGivenMoves(Move firstPlayerMove, Move secondPlayerMove) {
        forGivenMoves(firstPlayerMove, secondPlayerMove);
        return game.play(firstPlayer, secondPlayer);
    }

    private void forGivenMoves(Move firstPlayerMove, Move secondPlayerMove) {
        given(firstPlayer.getMove()).willReturn(firstPlayerMove);
        given(secondPlayer.getMove()).willReturn(secondPlayerMove);
    }

    private void assertThatTestResultHasGivenOutcomeAndReason(Result result, Outcome givenOutcome, Reason givenReason) {
        assertThat(result.getOutcome(), is(equalTo(givenOutcome)));
        assertThat(result.getReason(), is(equalTo(givenReason)));
    }
}
