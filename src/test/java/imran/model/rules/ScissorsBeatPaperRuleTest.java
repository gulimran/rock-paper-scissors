package imran.model.rules;

import imran.model.player.Player;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static imran.representation.move.Move.PAPER;
import static imran.representation.move.Move.ROCK;
import static imran.representation.move.Move.SCISSORS;
import static imran.representation.result.Outcome.LOSE;
import static imran.representation.result.Outcome.TIE;
import static imran.representation.result.Outcome.WIN;
import static imran.representation.result.Reason.SCISSORS_BEAT_PAPER;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class ScissorsBeatPaperRuleTest {

    private ScissorsBeatPaperRule strategy;

    @Mock
    private Player firstPlayer;

    @Mock
    private Player secondPlayer;

    @Before
    public void setup() {
        strategy = new ScissorsBeatPaperRule();
    }

    @Test
    public void shouldReturnNull_WhenMove1IsNotScissorsAndMoveTwoIsPaper() {
        // given
        given(firstPlayer.getMove()).willReturn(ROCK);
        given(secondPlayer.getMove()).willReturn(PAPER);

        // when, then
        assertNull(strategy.apply(firstPlayer, secondPlayer));
    }

    @Test
    public void shouldReturnNull_WhenMove1IsScissorsAndMoveTwoIsNotPaper() {
        // given
        given(firstPlayer.getMove()).willReturn(SCISSORS);
        given(secondPlayer.getMove()).willReturn(ROCK);

        // when, then
        assertNull(strategy.apply(firstPlayer, secondPlayer));
    }

    @Test
    public void shouldReturnResultWithWinOutcome_WhenMove1IsScissorsAndMoveTwoIsPaper() {
        // given
        given(firstPlayer.getMove()).willReturn(SCISSORS);
        given(secondPlayer.getMove()).willReturn(PAPER);

        // when, then
        assertThat(strategy.apply(firstPlayer, secondPlayer).getOutcome(), is(equalTo(WIN)));
    }

    @Test
    public void shouldReturnResultWithLoseOutcome_WhenMove1IsPaperAndMoveTwoIsScissors() {
        // given
        given(firstPlayer.getMove()).willReturn(PAPER);
        given(secondPlayer.getMove()).willReturn(SCISSORS);

        // when, then
        assertThat(strategy.apply(firstPlayer, secondPlayer).getOutcome(), is(equalTo(LOSE)));
    }

    @Test
    public void shouldReturnResultWithTieOutcome_WhenMove1IsScissorsAndMoveTwoIsScissors() {
        // given
        given(firstPlayer.getMove()).willReturn(ROCK);
        given(secondPlayer.getMove()).willReturn(ROCK);

        // when, then
        assertThat(strategy.apply(firstPlayer, secondPlayer).getOutcome(), is(equalTo(TIE)));
    }

    @Test
    public void shouldReturnResultWithTieOutcome_WhenMove1IsPaperAndMoveTwoIsPaper() {
        // given
        given(firstPlayer.getMove()).willReturn(PAPER);
        given(secondPlayer.getMove()).willReturn(PAPER);

        // when, then
        assertThat(strategy.apply(firstPlayer, secondPlayer).getOutcome(), is(equalTo(TIE)));
    }
}
