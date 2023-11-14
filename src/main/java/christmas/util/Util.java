package christmas.util;

import java.text.NumberFormat;
import java.util.List;
import java.util.stream.Stream;

public class Util {
    public static String changeRegexToBlank(String target, String regex) {
        return target.replaceAll(regex, "");
    }

    public static String formattingNumber(int number) {
        return NumberFormat
                .getInstance()
                .format(number);
    }

    public static long distinctListSize(List<?> target) {
        return target.stream()
                .distinct()
                .count();
    }

    public static int intStreamSum(Stream<Integer> target) {
        return target.mapToInt(Integer::intValue)
                .sum();
    }
}
