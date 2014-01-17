package imran.model.rules;

import imran.context.ApplicationContext;
import imran.representation.move.Move;
import imran.representation.result.Outcome;
import imran.representation.result.Reason;
import imran.factory.move.MoveProvider;
import imran.model.player.Player;
import imran.model.player.RockPaperScissorsPlayer;
import imran.representation.result.Result;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static imran.representation.move.Move.*;
import static imran.representation.result.Outcome.*;
import static imran.representation.result.Reason.*;

@RunWith(MockitoJUnitRunner.class)
public class RockPaperScissorsRulesTest {

    private RockPaperScissorsRules rockPaperScissorsRules;

    @Mock
    private MoveProvider moveProvider1, moveProvider2;

    private Player firstPlayer;
    private Player secondPlayer;

    @Before
    public void setup() {
        rockPaperScissorsRules = new RockPaperScissorsRules();
        rockPaperScissorsRules.setApplicationContext(ApplicationContext.getInstance());
    }

    @Test
    public void firstPlayerShouldWin_WhenFirstPlayerThrowsRockAndSecondPlayerThrowsScissors() {
        assertThatTestResultHasGivenOutcomeAndReason(forGivenMoves(ROCK, SCISSORS), WIN, ROCK_BEATS_SCISSORS);
    }

    @Test
    public void firstPlayerShouldLose_WhenFirstPlayerThrowsRockAndSecondPlayerThrowsPaper() {
        assertThatTestResultHasGivenOutcomeAndReason(forGivenMoves(ROCK, PAPER), LOSE, PAPER_BEATS_ROCK);
    }

    @Test
    public void firstPlayerShouldTie_WhenFirstPlayerThrowsRockAndSecondPlayerThrowsRock() {
        assertThatTestResultHasGivenOutcomeAndReason(forGivenMoves(ROCK, ROCK), TIE, TIED);
    }

    @Test
    public void firstPlayerShouldWin_WhenFirstPlayerThrowsPaperAndSecondPlayerThrowsRock() {
        assertThatTestResultHasGivenOutcomeAndReason(forGivenMoves(PAPER, ROCK), WIN, PAPER_BEATS_ROCK);
    }

    @Test
    public void firstPlayerShouldLose_WhenFirstPlayerThrowsPaperAndSecondPlayerThrowsScissors() {
        assertThatTestResultHasGivenOutcomeAndReason(forGivenMoves(PAPER, SCISSORS), LOSE, SCISSORS_BEAT_PAPER);
    }

    @Test
    public void firstPlayerShouldTie_WhenFirstPlayerThrowsPaperAndSecondPlayerThrowsPaper() {
        assertThatTestResultHasGivenOutcomeAndReason(forGivenMoves(PAPER, PAPER), TIE, TIED);
    }

    @Test
    public void firstPlayerShouldWin_WhenFirstPlayerThrowsScissorsAndSecondPlayerThrowsPaper() {
        assertThatTestResultHasGivenOutcomeAndReason(forGivenMoves(SCISSORS, PAPER), WIN, SCISSORS_BEAT_PAPER);
    }

    @Test
    public void firstPlayerShouldLose_WhenFirstPlayerThrowsScissorsndSecondPlayerThrowsRock() {
        assertThatTestResultHasGivenOutcomeAndReason(forGivenMoves(SCISSORS, ROCK), LOSE, ROCK_BEATS_SCISSORS);
    }

    @Test
    public void firstPlayerShouldTie_WhenFirstPlayerThrowsScissorsAndSecondPlayerThrowsScissors() {
        assertThatTestResultHasGivenOutcomeAndReason(forGivenMoves(SCISSORS, SCISSORS), TIE, TIED);
    }

    private Result forGivenMoves(Move firstPlayerMove, Move secondPlayerMove) {
        firstPlayer = new RockPaperScissorsPlayer("firstPlayer", firstPlayerMove);
        secondPlayer = new RockPaperScissorsPlayer("secondPlayer", secondPlayerMove);

        return rockPaperScissorsRules.getResult(firstPlayer, secondPlayer);
    }

    private void assertThatTestResultHasGivenOutcomeAndReason(Result result, Outcome givenOutcome, Reason givenReason) {
        assertThat(result.getOutcome(), is(equalTo(givenOutcome)));
        assertThat(result.getReason(), is(equalTo(givenReason)));
    }

    public static List<Rule> getStrategies() {
        List<Rule> strategies = new ArrayList<Rule>();
        strategies.add(new RockBeatsScissorsRule());
        strategies.add(new ScissorsBeatPaperRule());
        strategies.add(new PaperBeatsRockRule());
        return strategies;
    }
}
