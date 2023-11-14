package christmas.model;

import christmas.config.Event;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class SpecialDayEvent {
    private static final int[] SPECIAL_DAYS = {3, 10, 17, 24, 25, 31};
    private static final int DISCOUNT_SPECIAL = 1000;

    private final int day;

    public SpecialDayEvent(int day) {
        this.day = day;
    }

    private boolean isSpecialDay() {
        return Arrays.stream(SPECIAL_DAYS)
                .anyMatch(specialDay -> specialDay == day);
    }

    public Map<Event, Integer> getDiscountInfo() {
        Map<Event, Integer> discountInfo = new EnumMap<>(Event.class);

        if (isSpecialDay()) {
            discountInfo.put(Event.SPECIAL, DISCOUNT_SPECIAL);
        }

        return discountInfo;
    }
}
