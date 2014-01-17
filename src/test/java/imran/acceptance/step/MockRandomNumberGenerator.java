package imran.acceptance.step;

import imran.util.RandomNumberGenerator;

public class MockRandomNumberGenerator extends RandomNumberGenerator {

    private int moveChoice;

    @Override
    public int getMoveChosen() {
        return moveChoice;
    }

    public void setMoveChoice(int moveChoice) {
        this.moveChoice = moveChoice;
    }
}
