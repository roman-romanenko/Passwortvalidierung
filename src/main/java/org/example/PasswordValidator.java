package org.example;

public final class PasswordValidator {
    public static boolean hasMinLength(String password, int min) {
        return password != null && password.length() >= min;
    }

    public static boolean containsDigit(String password) {
        String numbers = "0123456789";
        String[] passwordSymbolsArray = password.split("");

        for (String symbol : passwordSymbolsArray) {
            if(numbers.contains(symbol) ) {
                return true;
            }
        }

        return false;
    }

    public static boolean containsUpperAndLower(String password) {
        String[] passwordSymbolsArray = password.split("");
        boolean containsUpper = false;
        boolean containsLower = false;

        for (String symbol : passwordSymbolsArray) {
            if(!containsUpper && symbol.equals(symbol.toUpperCase())) {
                containsUpper = true;
            } else if(!containsLower && symbol.equals(symbol.toLowerCase())) {
                containsLower = true;
            }

            if(containsUpper && containsLower) {
                return true;
            }
        }
        return false;
    }

    public static boolean isCommonPassword(String password) {
        String[] commonPasswords = { "12345678", "password", "Passwort1", "Aa345678" };

            for(String commonPassword : commonPasswords) {
                if(password.equals(commonPassword)) {
                    return true;
                }
            }

        return false;
    }


    public static boolean containsSpecialChar(String password, String allowed) {
        for(String specialChar : allowed.split("")) {
            if(password.contains(specialChar)) {
                return true;
            }
        }
        return false;
    }


    public static boolean isValid(String password) {
        int minLength = 8;
        String allowedChars = "(!#$%()*+,-./:;=?@[]^_{|}~)";

        return hasMinLength(password, minLength) &&
                containsDigit(password) &&
                containsUpperAndLower(password) &&
                !isCommonPassword(password) &&
                containsSpecialChar(password, allowedChars) ;
    }
}
