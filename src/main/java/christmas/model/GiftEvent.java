package christmas.model;

import christmas.config.Event;
import christmas.config.Gift;
import christmas.config.Menu;

import java.util.EnumMap;
import java.util.Map;

public class GiftEvent implements DiscountEventInterface {
    private final int totalPrice;

    public GiftEvent(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    private Gift getGift() {
        return Gift.getGift(totalPrice);
    }

    private String getGiftMenu() {
        return getGift().getMenu();
    }

    @Override
    public boolean isDiscountTarget() {
        return !getGift().equals(Gift.NONE);
    }

    private int getGiftPrice() {
        return Menu.getMenu(getGiftMenu())
                .getPrice();
    }

    @Override
    public Map<Event, Integer> getDiscountInfo() {
        Map<Event, Integer> discountInfo = new EnumMap<>(Event.class);

        if (isDiscountTarget()) {
            discountInfo.put(Event.GIFT, getGiftPrice());
        }

        return discountInfo;
    }
}
