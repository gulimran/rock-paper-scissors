package imran.factory.move;

import imran.representation.move.Move;
import imran.view.InteractiveConsole;
import imran.validator.MoveValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class InteractiveMoveProviderTest {

    @InjectMocks
    private InteractiveMoveProvider interactiveMoveProvider;

    @Mock
    private MoveValidator validator;

    @Mock
    private InteractiveConsole console;

    @Test
    public void shouldReturnRockMove_OnGetNextMove() {
        // given
        Move expected = Move.ROCK;
        given(console.getMoveChosen()).willReturn("1");

        // when
        Move actual = interactiveMoveProvider.getMove();

        // then
        assertThat(actual, is(expected));
    }

    @Test
    public void shouldReturnPaperMove_OnGetNextMove() {
        // given
        Move expected = Move.PAPER;
        given(console.getMoveChosen()).willReturn("2");

        // when
        Move actual = interactiveMoveProvider.getMove();

        // then
        assertThat(actual, is(expected));
    }

    @Test
    public void shouldReturnScissorsMove_OnGetNextMove() {
        // given
        Move expected = Move.SCISSORS;
        given(console.getMoveChosen()).willReturn("3");

        // when
        Move actual = interactiveMoveProvider.getMove();

        // then
        assertThat(actual, is(expected));
    }
}
