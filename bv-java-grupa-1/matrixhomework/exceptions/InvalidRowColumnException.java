package exceptions;

public class InvalidRowColumnException extends Exception{
    public InvalidRowColumnException() {
        super("Please enter a valid row and column!");
    }
}
