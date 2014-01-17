package imran.model.rules;

import imran.model.player.Player;
import imran.representation.result.Result;

public interface Rule {
    Result apply(Player firstPlayer, Player secondPlayer);
}
