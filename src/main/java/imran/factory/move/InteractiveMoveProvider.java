package imran.factory.move;

import imran.context.ApplicationContext;
import imran.representation.move.Move;
import imran.view.InteractiveConsole;
import imran.validator.MoveValidator;

public class InteractiveMoveProvider implements MoveProvider {

    private MoveValidator validator;
    private InteractiveConsole console;

    @Override
    public Move getMove() {
        String selectedOption = console.getMoveChosen();
        validator.validate(selectedOption);
        return Move.values()[Integer.parseInt(selectedOption) - 1];
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.validator = (MoveValidator) applicationContext.getBean(MoveValidator.class);
        this.console = (InteractiveConsole) applicationContext.getBean(InteractiveConsole.class);
    }
}
