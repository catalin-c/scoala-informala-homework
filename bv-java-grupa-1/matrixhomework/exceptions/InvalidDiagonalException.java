package exceptions;

public class InvalidDiagonalException extends Exception {
    public InvalidDiagonalException() {
        super("Please enter a valid diagonal value!");
    }
}
