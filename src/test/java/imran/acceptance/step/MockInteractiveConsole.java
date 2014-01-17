package imran.acceptance.step;

import imran.view.InteractiveConsole;

public class MockInteractiveConsole extends InteractiveConsole {

    private String mainMenuChoice;
    private String moveChoice;

    @Override
    public String getMainMenuChoice() {
        return mainMenuChoice;
    }

    public void setMainMenuChoice(String mainMenuChoice) {
        this.mainMenuChoice = mainMenuChoice;
    }

    @Override
    public String getMoveChosen() {
        return moveChoice;
    }

    public void setMoveChoice(String moveChoice) {
        this.moveChoice = moveChoice;
    }
}
