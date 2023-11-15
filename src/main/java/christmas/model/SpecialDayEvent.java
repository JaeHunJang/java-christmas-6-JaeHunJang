package christmas.model;

import christmas.config.Event;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class SpecialDayEvent implements DiscountEventInterface {
    private static final int[] SPECIAL_DAYS = {3, 10, 17, 24, 25, 31};
    private static final int DISCOUNT_SPECIAL = 1000;

    private final int visitDate;

    public SpecialDayEvent(int visitDate) {
        this.visitDate = visitDate;
    }

    @Override
    public boolean isDiscountTarget() {
        return Arrays.stream(SPECIAL_DAYS)
                .anyMatch(specialDay -> specialDay == visitDate);
    }

    @Override
    public Map<Event, Integer> getDiscountInfo() {
        Map<Event, Integer> discountInfo = new EnumMap<>(Event.class);

        if (isDiscountTarget()) {
            discountInfo.put(Event.SPECIAL, DISCOUNT_SPECIAL);
        }

        return discountInfo;
    }
}
