package imran.model.player;

public enum PlayerType {
    PERSON("Player"),
    COMPUTER("Computer");

    private String description;

    PlayerType(String description) {
        this.description = description;
    }

    public String toString() {
        return description;
    }
}
