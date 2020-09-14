package controller.exception;

public class SeleniumInitException extends Exception {

    public SeleniumInitException(String message) {
        super(message);
    }

    public SeleniumInitException(String message, Throwable cause) {
        super(message, cause);
    }

    public SeleniumInitException(Throwable cause) {
        super(cause);
    }
}
