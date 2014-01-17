package imran.validator;

import imran.error.InvalidMoveException;
import imran.validator.MoveValidator;
import org.junit.Before;
import org.junit.Test;

public class MoveValidatorTest {

    private MoveValidator validator;

    @Before
    public void setup() {
        validator = new MoveValidator();
    }

    @Test
    public void shouldvalidate_WhenInputIsInRange() {
        validator.validate("2");
    }

    @Test(expected = InvalidMoveException.class)
    public void shouldThrowException_WhenInputIsZero() {
        validator.validate("0");
    }

    @Test(expected = InvalidMoveException.class)
    public void shouldThrowException_WhenInputIsNonNumeric() {
        validator.validate("A");
    }

    @Test(expected = InvalidMoveException.class)
    public void shouldThrowException_WhenInputIsOutOfRange() {
        validator.validate("4");
    }

    @Test(expected = InvalidMoveException.class)
    public void shouldThrowException_WhenInputIsNegative() {
        validator.validate("-2");
    }
}
