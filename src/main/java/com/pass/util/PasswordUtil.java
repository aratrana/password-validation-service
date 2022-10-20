package com.pass.util;

public class PasswordUtil {
    public static String getMatchingCharacters(
            final String characters,
            final String input) {
        final StringBuilder sb = new StringBuilder(input.length());
        for (int i = 0; i < input.length(); i++) {
            final char c = input.charAt(i);
            if (characters.indexOf(c) != -1) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
