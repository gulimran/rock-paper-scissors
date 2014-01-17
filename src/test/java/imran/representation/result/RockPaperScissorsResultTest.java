package imran.representation.result;

import imran.model.player.Player;
import imran.model.player.RockPaperScissorsPlayer;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RockPaperScissorsResultTest {

    private static final String FIRST_PLAYER_NAME = "firstPlayer";
    private static final String SECOND_PLAYER_NAME = "secondPlayer";

    private RockPaperScissorsResult rockPaperScissorsResult;

    private Player firstPlayer;
    private Player secondPlayer;

    @Before
    public void setup() {
        firstPlayer = new RockPaperScissorsPlayer(FIRST_PLAYER_NAME, null);
        secondPlayer = new RockPaperScissorsPlayer(SECOND_PLAYER_NAME, null);

        rockPaperScissorsResult = new RockPaperScissorsResult(firstPlayer, secondPlayer, Reason.ROCK_BEATS_SCISSORS, Outcome.WIN);
    }

    @Test
    public void shouldReturnExpectedFirstPlayer_OnGetFirstPlayer() {
        // given, when
        String actual = rockPaperScissorsResult.getFirstPlayer().getName();

        // then
        assertThat(actual, is(equalTo(FIRST_PLAYER_NAME)));
    }

    @Test
    public void shouldReturnExpectedSecondPlayer_OnGetSecondPlayer() {
        // given, when
        String actual = rockPaperScissorsResult.getSecondPlayer().getName();

        // then
        assertThat(actual, is(equalTo(SECOND_PLAYER_NAME)));
    }

    @Test
    public void shouldReturnExpectedReason_OnGetReason() {
        // given, when
        Reason actual = rockPaperScissorsResult.getReason();

        // then
        assertThat(actual, is(equalTo(Reason.ROCK_BEATS_SCISSORS)));
    }

    @Test
    public void shouldReturnExpectedOutcome_OnGetOutcome() {
        // given, when
        Outcome actual = rockPaperScissorsResult.getOutcome();

        // then
        assertThat(actual, is(equalTo(Outcome.WIN)));
    }
}
