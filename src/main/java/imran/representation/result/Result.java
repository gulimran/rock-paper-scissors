package imran.representation.result;

import imran.model.player.Player;

public interface Result {
    Player getFirstPlayer();
    Player getSecondPlayer();
    Outcome getOutcome();
    Reason getReason();
}
