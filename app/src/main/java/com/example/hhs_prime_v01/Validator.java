package com.example.hhs_prime_v01;


public class Validator {
    public static boolean inputValidString(String userInput) {
        if (userInput == null || userInput.isEmpty()) {
            return false;
        }
        for (char c : userInput.toCharArray()) {
            if (!java.lang.Character.isAlphabetic(c) && c != ' ') {
                return false;
            }
        }
        return true;
    }

    // TODO: uitwerken numeric validator
    public static boolean isNumeric(String seasonsString) {
        return true;
    }
}
