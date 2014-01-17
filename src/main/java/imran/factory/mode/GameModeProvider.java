package imran.factory.mode;

import imran.context.ApplicationContext;
import imran.representation.mode.GameModes;
import imran.validator.GameModeValidator;

public class GameModeProvider {

    private GameModeValidator validator;

    public GameModes getGameMode(String gameModeOption) {
        validator.validate(gameModeOption);
        return GameModes.values()[Integer.parseInt(gameModeOption) - 1];
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.validator = (GameModeValidator) applicationContext.getBean(GameModeValidator.class);
    }
}
