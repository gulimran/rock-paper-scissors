package imran.representation.result;

public enum Outcome {
    WIN(" wins."),
    LOSE(" loses."),
    TIE(" ties.");

    private String description;

    Outcome(String description) {
        this.description = description;
    }

    public String toString() {
        return description;
    }
}
