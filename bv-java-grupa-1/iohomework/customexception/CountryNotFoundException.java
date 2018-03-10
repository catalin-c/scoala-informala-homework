package customexception;

public class CountryNotFoundException extends Exception {
    public CountryNotFoundException() {
        super("Please enter a valid country name!");
    }
}
