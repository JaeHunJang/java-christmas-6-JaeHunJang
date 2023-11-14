package christmas.model;

import christmas.config.Event;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class WeekendEvent {
    private static final int[] WEEKENDS = {5, 6};
    private static final int DISCOUNT_WEEKEND_PRICE = 2023;

    private final int day;
    private final int mainQuantity;

    public WeekendEvent(int day, int mainQuantity) {
        this.day = day;
        this.mainQuantity = mainQuantity;
    }

    private boolean isWeekend() {
        return Arrays.stream(WEEKENDS)
                .anyMatch(weekend -> weekend == day);
    }

    public Map<Event, Integer> getDiscountInfo() {
        Map<Event, Integer> discountInfo = new EnumMap<>(Event.class);

        if (isWeekend()) {
            discountInfo.put(Event.WEEKEND, mainQuantity * DISCOUNT_WEEKEND_PRICE);
        }

        return discountInfo;
    }
}
