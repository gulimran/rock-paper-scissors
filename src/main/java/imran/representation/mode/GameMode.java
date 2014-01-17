package imran.representation.mode;

import imran.model.player.PlayerType;

public interface GameMode {
    PlayerType getFirstPlayerType();
    PlayerType getSecondPlayerType();
    String getFirstPlayerName();
    String getSecondPlayerName();
}
