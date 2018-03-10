import customexception.CountryNotFoundException;
import dataprocessing.ProcessCountryData;
import org.junit.Test;

public class ProcessCountryDataTest {

    @Test(expected = CountryNotFoundException.class)
    public void printCountryInfoTestException() throws CountryNotFoundException {
        ProcessCountryData processCountryData = new ProcessCountryData();
        processCountryData.printCountryInfo("country");
    }

    @Test
    public void printCountryInfoTestNoException() {
        ProcessCountryData processCountryData = new ProcessCountryData();
        try {
            processCountryData.printCountryInfo("romania");
        } catch (CountryNotFoundException e) {
            e.printStackTrace();
        }
    }
}
