package exceptions;

public class InvalidSizeException extends Exception {
    public InvalidSizeException() {
        super("Please enter a valid size!");
    }
}
