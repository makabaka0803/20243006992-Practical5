package com.example.practical5;

public class TextProcessor {

    // Store the list of valid municipality names
    private final String[] cityArray;

    // Constructor receives the valid municipality string‑array from activity
    public TextProcessor(String[] inputArray) {
        cityArray = inputArray;
    }

    // Check whether user input is a valid municipality, case‑insensitive
    public boolean isValidCity(String userInput) {
        if (userInput == null || userInput.isEmpty()) {
            return false;
        }
        String inputTrim = userInput.trim();
        for (String city : cityArray) {
            if (city.equalsIgnoreCase(inputTrim)) {
                return true;
            }
        }
        return false;
    }

    // Return properly capitalised municipality name; return null for invalid input
    public String getStandardName(String userInput) {
        if (userInput == null || userInput.isEmpty()) {
            return null;
        }
        String inputTrim = userInput.trim();
        for (String city : cityArray) {
            if (city.equalsIgnoreCase(inputTrim)) {
                return city;
            }
        }
        return null;
    }
}
