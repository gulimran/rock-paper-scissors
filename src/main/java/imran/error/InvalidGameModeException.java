package imran.error;

public class InvalidGameModeException extends GameException {
    public InvalidGameModeException() {
    }

    public InvalidGameModeException(String message) {
        super(message);
    }

    public InvalidGameModeException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidGameModeException(Throwable cause) {
        super(cause);
    }
}
