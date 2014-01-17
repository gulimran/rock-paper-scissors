package imran.representation.result;

public enum Reason {
    ROCK_BEATS_SCISSORS("Rock beats Scissors. "),
    PAPER_BEATS_ROCK("Paper beats Rock. "),
    SCISSORS_BEAT_PAPER("Scissors beat Paper. "),
    TIED("");

    private String description;

    Reason(String description) {
        this.description = description;
    }

    public String toString() {
        return description;
    }
}
