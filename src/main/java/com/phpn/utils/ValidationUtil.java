package com.phpn.utils;

import java.util.regex.Pattern;

public class ValidationUtil {

    private static final String PASSWORD_REGEX = "^.{5,128}$";

    public static boolean isValidPassword(String password) {
        return Pattern.matches(PASSWORD_REGEX, password);
    }

}