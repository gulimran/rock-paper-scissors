package imran.factory.mode;

import imran.representation.mode.GameModes;
import imran.validator.GameModeValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class GameModeProviderTest {

    @InjectMocks
    private GameModeProvider gameModeProvider;

    @Mock
    private GameModeValidator validator;

    @Test
    public void shouldProvidePersonVsComputerGameMode_WhenFirstOptionIsSelected() {
        // given
        GameModes expected = GameModes.PLAYER_VS_COMPUTER;

        // when
        GameModes actual = gameModeProvider.getGameMode("1");

        // then
        assertThat(actual, is(equalTo(expected)));
    }

    @Test
    public void shouldProvideComputerVsComputerGameMode_WhenSecondOptionIsSelected() {
        // given
        GameModes expected = GameModes.COMPUTER_VS_COMPUTER;

        // when
        GameModes actual = gameModeProvider.getGameMode("2");

        // then
        assertThat(actual, is(equalTo(expected)));
    }
}
