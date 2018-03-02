package dataprocessing;

import java.util.Map;

/**
 * Is used to organize the information about each country.
 */
public class CountryData {
    private String name;
    private Map<String, String> countryInfo;

    public CountryData(String name, Map<String, String> countryInfo) {
        this.name = name;
        this.countryInfo = countryInfo;
    }

    public String getName() {
        return name;
    }

    public Map<String, String> getCountryInfo() {
        return countryInfo;
    }


}
