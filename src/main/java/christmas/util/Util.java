package christmas.util;

import java.text.NumberFormat;
import java.util.List;

public class Util {
    public static List<String> stringToList(String string, String delimiter) {
        return List.of(string.split(delimiter));
    }

    public static String formattingNumber(int number) {
        return NumberFormat
                .getInstance()
                .format(number);
    }
}
