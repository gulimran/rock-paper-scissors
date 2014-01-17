package imran.view;

import imran.representation.result.Result;

import java.io.Console;

public class InteractiveConsole {

    public static final String NEW_LINE = System.getProperty("line.separator");
    public static final Console CONSOLE = System.console();

    public String getMainMenu() {
        StringBuilder builder = new StringBuilder();
        builder.append(NEW_LINE);
        builder.append("ROCK, PAPER, SCISSORS");
        builder.append(NEW_LINE);
        builder.append("Player vs Computer (enter \"1\")");
        builder.append(NEW_LINE);
        builder.append("Computer vs Computer (enter \"2\")");
        builder.append(NEW_LINE);
        return builder.toString();
    }

    public String getMainMenuChoice() {
        CONSOLE.printf(getMainMenu());
        return CONSOLE.readLine(">> How do you like to play? (return to exit): ");
    }

    public String getMoveChosen() {
        return CONSOLE.readLine(">> Select ROCK (enter \"1\"), PAPER (enter \"2\") or SCISSORS (enter \"3\"): ");
    }

    public void displayResult(Result result) {
        CONSOLE.printf(result.getFirstPlayer().getName());
        CONSOLE.printf(" played ");
        CONSOLE.printf(result.getFirstPlayer().getMove().toString());
        CONSOLE.printf(". ");
        CONSOLE.printf(result.getSecondPlayer().getName());
        CONSOLE.printf(" played ");
        CONSOLE.printf(result.getSecondPlayer().getMove().toString());
        CONSOLE.printf(". ");
        CONSOLE.printf(result.getReason().toString());
        CONSOLE.printf(result.getFirstPlayer().getName());
        CONSOLE.printf(result.getOutcome().toString());
        CONSOLE.printf(NEW_LINE);
        CONSOLE.printf(NEW_LINE);
    }

    public void displayError(String message) {
        CONSOLE.printf("ERROR: "+message);
        CONSOLE.printf(NEW_LINE);
        CONSOLE.printf(NEW_LINE);
    }
}
