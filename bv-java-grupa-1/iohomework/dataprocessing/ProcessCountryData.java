package dataprocessing;

import customexception.CountryNotFoundException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

/**
 * Deals with all the data processing from the online document.
 */
public class ProcessCountryData {
    // Stores a list with country objects.
    private List<CountryData> countryList = new ArrayList<>();

    public ProcessCountryData() {
        addCountries();
    }

    /**
     * @return a list with every line from the online document.
     */
    public List<String> getURLData() {
        List<String> linesList = new ArrayList<>();

        try {
            URL url = new URL("https://openei.org/doe-opendata/dataset/a7fea769-691d-4536-8ed3-471e993a2445/resource/86c50aa8-e40f-4859-b52e-29bb10166456/download/populationbycountry19802010millions.csv");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;

            while ((line = in.readLine()) != null ) {
                linesList.add(line);
            }
            in.close();
        } catch (MalformedURLException e) {
            System.out.println("Malformed URL: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
        }
        return linesList;
    }

    /**
     * Takes the data retrieved from the online document and organizes it in a list of Objects, each representing
     * a different country.
     */
    public void addCountries() {
        List<String> countriesData = getURLData();

        // Stores all the years from 1990 to 2010.
        String[] yearList = countriesData.get(0).split(",");

        // Stores the name of a country + the population information for every year.
        String[] country = null;


        for (int i = 1; i < countriesData.size(); i++) {
            // Stores all the information about a country (year - population number).
            Map<String, String> countryInfo = new TreeMap<>();

            // Removes all the unwanted characters (like extra commas or quotes).
            if(countriesData.get(i).contains("\"")) {
                String newCountryName = countriesData.get(i).replaceFirst(",", "");
                String countryNameFixed = newCountryName.replaceAll("\"", "");
                countriesData.set(i, countryNameFixed);
                country = countriesData.get(i).split(",");
            } else {
                country = countriesData.get(i).split(",");
            }

            for (int j = 1; j < country.length; j++) {
                countryInfo.put(yearList[j], country[j]);
            }

            countryList.add(new CountryData(country[0], countryInfo));
        }
    }

    /**
     * Takes a country name as parameter and displays all the information about the country if it exists in the
     * country objects list. Otherwise it will throw a custom CountryNotFoundException and inform the user
     * about the problem.
     *
     * @param countryName is the country name given by the user.
     */
    public void printCountryInfo(String countryName) throws CountryNotFoundException {
        boolean isValidCountryName = false;

        for (CountryData countryData : countryList) {
            if(countryData.getName().toLowerCase().equals(countryName)) {
                isValidCountryName = true;

                System.out.println(countryData.getName() + ": ");
                for (String year : countryData.getCountryInfo().keySet()) {
                    System.out.println("Year: " + year + " - Population: " + countryData.getCountryInfo().get(year));
                }
            }
        }
        if (!isValidCountryName) {
            throw new CountryNotFoundException();
        }
    }


}
