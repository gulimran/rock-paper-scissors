package imran.service;

import imran.model.player.Player;
import imran.representation.result.Result;

public interface Game {
    Result play(Player firstPlayer, Player secondPlayer);
}
