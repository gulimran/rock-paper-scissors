package imran.validator;

import imran.error.InvalidGameModeException;
import imran.validator.GameModeValidator;
import org.junit.Before;
import org.junit.Test;

public class GameModeValidatorTest {

    private GameModeValidator validator;

    @Before
    public void setup() {
        validator = new GameModeValidator();
    }

    @Test
    public void shouldValidate_WhenInputIsInRange() {
        validator.validate("2");
    }

    @Test(expected = InvalidGameModeException.class)
    public void shouldThrowException_WhenInputIsNonNumeric() {
        validator.validate("A");
    }

    @Test(expected = InvalidGameModeException.class)
    public void shouldThrowException_WhenInputIsOutOfRange() {
        validator.validate("3");
    }

    @Test(expected = InvalidGameModeException.class)
    public void shouldThrowException_WhenInputIsNegative() {
        validator.validate("-2");
    }

    @Test(expected = InvalidGameModeException.class)
    public void shouldThrowException_WhenInputIsZero() {
        validator.validate("0");
    }
}
