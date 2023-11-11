package christmas.util;

import java.util.List;

public class Util {
    public static List<String> stringToList(String string, String delimiter) {
        return List.of(string.split(delimiter));
    }
}
