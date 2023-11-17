package christmas.model;

import christmas.config.Event;

import java.util.Map;

public interface DiscountEventInterface {
    boolean isDiscountTarget();

    Map<Event, Integer> getDiscountInfo();
}
