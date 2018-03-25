package exceptions;

public class IdNotFoundException extends Exception {
    public IdNotFoundException() {
        super("There isn't any data by the given id.");
    }
}
