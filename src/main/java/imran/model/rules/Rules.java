package imran.model.rules;

import imran.model.player.Player;
import imran.representation.result.Result;

public interface Rules {
    Result getResult(Player firstPlayer, Player secondPlayer);
}
