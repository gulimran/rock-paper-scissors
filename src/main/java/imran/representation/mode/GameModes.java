package imran.representation.mode;

import imran.model.player.PlayerType;

public enum GameModes implements GameMode {
    PLAYER_VS_COMPUTER(PlayerType.PERSON, "Player", PlayerType.COMPUTER, "Computer"),
    COMPUTER_VS_COMPUTER(PlayerType.COMPUTER, "Computer-1", PlayerType.COMPUTER, "Computer-2");

    private PlayerType firstPlayerType;
    private PlayerType secondPlayerType;
    private String firstPlayerName;
    private String secondPlayerName;

    GameModes(PlayerType firstPlayerType, String firstPlayerName, PlayerType secondPlayerType, String secondPlayerName) {
        this.firstPlayerType = firstPlayerType;
        this.secondPlayerType = secondPlayerType;
        this.firstPlayerName = firstPlayerName;
        this.secondPlayerName = secondPlayerName;
    }

    @Override
    public PlayerType getFirstPlayerType() { return firstPlayerType; }

    @Override
    public PlayerType getSecondPlayerType() {
        return secondPlayerType;
    }

    @Override
    public String getFirstPlayerName() { return firstPlayerName; }

    @Override
    public String getSecondPlayerName() { return secondPlayerName; }
}
