package christmas.model;

import christmas.config.Constant;
import christmas.config.Event;
import christmas.config.Menu;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Promotion {
    private final Map<Event, Integer> promotion;

    public Promotion() {
        promotion = generatePromotion();
    }

    private Map<Event, Integer> generatePromotion() {
        return Arrays.stream(Event.values())
                .collect(Collectors.toMap(event -> event, event -> 0));
    }

    public void discountGift(int totalPrice) {
        if (totalPrice >= Constant.GIFT_LIMIT_PRICE) {
            promotion.put(Event.GIFT, Menu.CHAMPAGNE.getPrice());
        }
    }

    public boolean hasGift() {
        return promotion.get(Event.GIFT) > 0;
    }
}
