package imran.model.player;

import imran.representation.move.Move;
import imran.factory.move.MoveProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class RockPaperScissorsPlayerTest {

    private RockPaperScissorsPlayer rockPaperScissorsPlayer;

    @Mock
    private MoveProvider moveProvider;

    @Test
    public void shouldReturnGivenPlayerName() {
        // given
        String playerName = "testPlayerName";
        rockPaperScissorsPlayer = new RockPaperScissorsPlayer(playerName, null);

        // when
        String actual = rockPaperScissorsPlayer.getName();

        // then
        assertThat(actual, is(playerName));
    }

    @Test
    public void shouldReturnGivenMoveProvider() {
        // given
        rockPaperScissorsPlayer = new RockPaperScissorsPlayer(null, Move.ROCK);

        // when
        Move actual = rockPaperScissorsPlayer.getMove();

        // then
        assertThat(actual, is(Move.ROCK));
    }
}
