package imran.factory.move;

import imran.representation.move.Move;
import imran.util.RandomNumberGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class RandomizedMoveProviderTest {

    @InjectMocks
    private RandomizedMoveProvider randomizedMoveProvider;

    @Mock
    private RandomNumberGenerator generator;

    @Test
    public void shouldReturnRockMove_OnGetNextMove() {
        // given
        given(generator.getMoveChosen()).willReturn(0);
        Move expected = Move.ROCK;

        // when
        Move actual = randomizedMoveProvider.getMove();

        // then
        assertThat(actual, is(expected));
    }

    @Test
    public void shouldReturnPaperMove_OnGetNextMove() {
        // given
        given(generator.getMoveChosen()).willReturn(1);
        Move expected = Move.PAPER;

        // when
        Move actual = randomizedMoveProvider.getMove();

        // then
        assertThat(actual, is(expected));
    }

    @Test
    public void shouldReturnScissorsMove_OnGetNextMove() {
        // given
        given(generator.getMoveChosen()).willReturn(2);
        Move expected = Move.SCISSORS;

        // when
        Move actual = randomizedMoveProvider.getMove();

        // then
        assertThat(actual, is(expected));
    }
}
