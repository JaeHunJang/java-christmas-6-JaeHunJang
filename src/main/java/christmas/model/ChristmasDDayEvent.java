package christmas.model;

import christmas.config.Event;

import java.util.EnumMap;
import java.util.Map;

public class ChristmasDDayEvent {
    private static final int START_D_DAY = 1;
    private static final int END_D_DAY = 25;
    private static final int DISCOUNT_CHRISTMAS = 1000;
    private static final int DISCOUNT_CHRISTMAS_UNIT = 100;

    private final int day;

    public ChristmasDDayEvent(int day) {
        this.day = day;
    }

    private int getDDayCount() {
        if (day > END_D_DAY)
            return -1;
        return day - START_D_DAY;
    }

    public Map<Event, Integer> getDiscountInfo() {
        Map<Event, Integer> discountInfo = new EnumMap<>(Event.class);

        if (getDDayCount() >= 0) {
            discountInfo.put(Event.CHRISTMAS, DISCOUNT_CHRISTMAS + DISCOUNT_CHRISTMAS_UNIT * getDDayCount());
        }

        return discountInfo;
    }
}
