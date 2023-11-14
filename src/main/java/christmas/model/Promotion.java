package christmas.model;

import christmas.config.Constant;
import christmas.config.Event;
import christmas.config.GiftEvent;
import christmas.config.Menu;
import christmas.util.Util;

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

    public void discountGift(GiftEvent giftEvent) {
        promotion.put(Event.GIFT, Menu.getMenu(giftEvent.getMenu()).getPrice() * giftEvent.getQuantity());
    }

    public void discountWeekday(int desertQuantity) {
        promotion.put(Event.WEEKDAY, desertQuantity * Constant.DISCOUNT_WEEK_PRICE);
    }

    public void discountWeekend(int mainQuantity) {
        promotion.put(Event.WEEKEND, mainQuantity * Constant.DISCOUNT_WEEK_PRICE);
    }

    public void discountSpecial() {
        promotion.put(Event.SPECIAL, Constant.DISCOUNT_SPECIAL);
    }

    public void discountDDay(int dayCount) {
        if (dayCount >= 0) {
            promotion.put(Event.CHRISTMAS, Constant.DISCOUNT_CHRISTMAS + Constant.DISCOUNT_CHRISTMAS_UNIT * dayCount);
        }
    }

    public Map<String, Integer> getPromotionList() {
        return promotion.entrySet()
                .stream()
                .filter(event -> event.getValue() > 0)
                .collect(Collectors.toMap(event -> event.getKey().getName(), Map.Entry::getValue));
    }

    public int getTotalDiscount() {
        return Util.intStreamSum(promotion.values()
                .stream());
    }

    public int getDiscount() {
        return Util.intStreamSum(promotion.entrySet()
                .stream()
                .filter(event -> event.getKey() != Event.GIFT)
                .map(Map.Entry::getValue));
    }
}
