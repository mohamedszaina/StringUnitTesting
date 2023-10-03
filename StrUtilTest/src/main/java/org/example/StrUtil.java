package org.example;

public class StrUtil {

    public static int stringLength(String input) {
        if (input == null) {
            return 0;
        }
        return input.length();
    }

    public static int stringLengthTrim(String input) {
        if (input == null) {
            return 0;
        }
        return input.trim().length();
    }
}
