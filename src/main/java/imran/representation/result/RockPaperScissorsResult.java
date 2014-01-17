package imran.representation.result;

import imran.model.player.Player;

public class RockPaperScissorsResult implements Result {

    private final Player firstPlayer;
    private final Player secondPlayer;
    private final Outcome outcome;
    private final Reason reason;

    public RockPaperScissorsResult(
            Player firstPlayer,
            Player secondPlayer,
            Reason reason, Outcome outcome) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.outcome = outcome;
        this.reason = reason;
    }

    @Override
    public Player getFirstPlayer() {
        return firstPlayer;
    }

    @Override
    public Player getSecondPlayer() {
        return secondPlayer;
    }

    @Override
    public Outcome getOutcome() {
        return outcome;
    }

    @Override
    public Reason getReason() {
        return reason;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(firstPlayer.getName());
        builder.append(" played ");
        builder.append(firstPlayer.getMove());
        builder.append(". ");
        builder.append(secondPlayer.getName());
        builder.append(" played ");
        builder.append(secondPlayer.getMove());
        builder.append(". ");
        builder.append(reason.toString());
        builder.append(firstPlayer.getName());
        builder.append(outcome.toString());
        return  builder.toString();
    }
}
