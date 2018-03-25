package exceptions;

public class InvalidLineException extends Exception {
    public InvalidLineException() {
        super("Please enter a valid line!");
    }
}
