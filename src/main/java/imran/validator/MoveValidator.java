package imran.validator;

import imran.error.InvalidMoveException;
import imran.representation.move.Move;

public class MoveValidator {

    private static final int MAX_SIZE = Move.values().length;

    public void validate(String input) {
        int intValue;

        try {
            intValue = Integer.parseInt(input);
        }
        catch (NumberFormatException e) {
            throw new InvalidMoveException("Invalid move option " + input);
        }

        if (intValue <= 0 || intValue > MAX_SIZE) {
            throw new InvalidMoveException("Invalid move option " + input);
        }
    }
}
