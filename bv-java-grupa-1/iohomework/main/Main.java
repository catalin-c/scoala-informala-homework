package main;

import customexception.CountryNotFoundException;
import dataprocessing.ProcessCountryData;

import static utils.UserInput.getUserInput;


public class Main {
    public static void main(String[] args) {
        ProcessCountryData processCountryData = new ProcessCountryData();

        while (true) {
            System.out.print("Enter a country's name: ");
            String country = getUserInput();

            if(country.equals("exit")) {
                break;
            }

            try {
                processCountryData.printCountryInfo(country);
            } catch (CountryNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
