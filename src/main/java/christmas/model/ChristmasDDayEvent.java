package christmas.model;

import christmas.config.Constant;
import christmas.config.Event;

import java.util.EnumMap;
import java.util.Map;

public class ChristmasDDayEvent implements DiscountEventInterface {
    private static final int START_D_DAY = 1;
    private static final int END_D_DAY = 25;
    private static final int DISCOUNT_CHRISTMAS = 1000;
    private static final int DISCOUNT_CHRISTMAS_UNIT = 100;

    private final int visitDate;

    public ChristmasDDayEvent(int visitDate) {
        this.visitDate = visitDate;
    }

    @Override
    public boolean isDiscountTarget() {
        return getDDayCount() >= 0;
    }

    private int getDDayCount() {
        if (visitDate <= END_D_DAY) {
            return visitDate - START_D_DAY;
        }
        return Constant.MINUS;
    }

    @Override
    public Map<Event, Integer> getDiscountInfo() {
        Map<Event, Integer> discountInfo = new EnumMap<>(Event.class);

        if (isDiscountTarget()) {
            discountInfo.put(Event.CHRISTMAS, DISCOUNT_CHRISTMAS + DISCOUNT_CHRISTMAS_UNIT * getDDayCount());
        }

        return discountInfo;
    }
}
