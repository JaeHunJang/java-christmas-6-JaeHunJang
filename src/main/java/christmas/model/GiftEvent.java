package christmas.model;

import christmas.config.Event;
import christmas.config.Gift;
import christmas.config.Menu;

import java.util.EnumMap;
import java.util.Map;

public class GiftEvent {
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

    private int getGiftPrice() {
        if (getGift().equals(Gift.NONE)) {
            return 0;
        }
        return Menu.getMenu(getGiftMenu())
                .getPrice();
    }

    public Map<Event, Integer> getDiscountInfo() {
        Map<Event, Integer> discountInfo = new EnumMap<>(Event.class);

        discountInfo.put(Event.GIFT, getGiftPrice());

        return discountInfo;
    }
}
