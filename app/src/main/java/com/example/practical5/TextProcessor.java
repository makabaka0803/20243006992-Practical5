package com.example.practical5;

public class TextProcessor {

    // Check whether the input municipality name is valid
    public static boolean isValid(String input) {
        if (input == null) return false;
        String city = input.trim();
        return city.equalsIgnoreCase("Beijing")
                || city.equalsIgnoreCase("Shanghai")
                || city.equalsIgnoreCase("Tianjin")
                || city.equalsIgnoreCase("Chongqing");
    }

    // Process input, return standardized city name
    public static String processMunicipality(String input) {
        if (input == null) return null;
        String raw = input.trim().toLowerCase();
        String result = null;
        switch (raw) {
            case "beijing":
                result = "Beijing";
                break;
            case "shanghai":
                result = "Shanghai";
                break;
            case "tianjin":
                result = "Tianjin";
                break;
            case "chongqing":
                result = "Chongqing";
                break;
            default:
                result = null;
                break;
        }
        return result;
    }
}
