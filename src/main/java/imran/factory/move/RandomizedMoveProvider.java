package imran.factory.move;

import imran.context.ApplicationContext;
import imran.representation.move.Move;
import imran.util.RandomNumberGenerator;

public class RandomizedMoveProvider implements MoveProvider {

    private RandomNumberGenerator generator;

    @Override
    public Move getMove() {
        int selectedOption = generator.getMoveChosen();
        return Move.values()[selectedOption];
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.generator = (RandomNumberGenerator) applicationContext.getBean(RandomNumberGenerator.class);
    }
}
