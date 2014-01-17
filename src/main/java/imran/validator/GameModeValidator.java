package imran.validator;

import imran.error.InvalidGameModeException;
import imran.representation.mode.GameModes;

public class GameModeValidator {

    private static final int MAX_SIZE = GameModes.values().length;

    public void validate(String input) {
        int intValue;

        try {
            intValue = Integer.parseInt(input);
        }
        catch (NumberFormatException e) {
            throw new InvalidGameModeException("Invalid game mode option " + input);
        }

        if (intValue <= 0 || intValue > MAX_SIZE) {
            throw new InvalidGameModeException("Invalid game mode option " + input);
        }
    }
}
