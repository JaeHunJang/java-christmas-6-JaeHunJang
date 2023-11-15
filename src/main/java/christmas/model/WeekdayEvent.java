package christmas.model;

import christmas.config.Event;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class WeekdayEvent implements DiscountEventInterface {
    private static final int[] WEEKDAYS = {1, 2, 3, 4, 7};
    private static final int DISCOUNT_WEEKDAY_PRICE = 2023;

    private final int day;
    private final int desertQuantity;

    public WeekdayEvent(int day, int desertQuantity) {
        this.day = day;
        this.desertQuantity = desertQuantity;
    }

    @Override
    public boolean isDiscountTarget() {
        return Arrays.stream(WEEKDAYS)
                .anyMatch(weekday -> weekday == day);
    }

    @Override
    public Map<Event, Integer> getDiscountInfo() {
        Map<Event, Integer> discountInfo = new EnumMap<>(Event.class);

        if (isDiscountTarget()) {
            discountInfo.put(Event.WEEKDAY, desertQuantity * DISCOUNT_WEEKDAY_PRICE);
        }

        return discountInfo;
    }
}
