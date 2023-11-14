package christmas.model;

import christmas.config.Event;
import christmas.config.Gift;
import christmas.config.Menu;
import christmas.util.Util;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Promotion {
    private final Map<Event, Integer> promotion;

    public Promotion() {
        promotion = new EnumMap<>(Event.class);
    }

    public void discountGift(Gift giftEvent) {
        promotion.put(Event.GIFT, Menu.getMenu(giftEvent.getMenu()).getPrice() * giftEvent.getQuantity());
    }

    public Map<String, Integer> getPromotionList() {
        return promotion.entrySet()
                .stream()
                .filter(event -> event.getValue() > 0)
                .collect(Collectors.toMap(
                        event -> event.getKey().getName(),
                        Map.Entry::getValue)
                );
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

    public void setDiscountInfo(Map<Event, Integer> discountInfo) {
        promotion.putAll(discountInfo);
    }
}
