package imran.model.player;

import imran.representation.move.Move;

public class RockPaperScissorsPlayer implements Player {

    private String name;
    private Move move;

    public RockPaperScissorsPlayer(String name, Move move) {
        this.name = name;
        this.move = move;
    }

    @Override
    public String getName() {



        return name;
    }

    @Override
    public Move getMove() { return move; }
}
