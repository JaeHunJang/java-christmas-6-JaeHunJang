package christmas.config;

import java.util.Arrays;

public enum GiftEvent {
    CHAMPAGNE("샴페인", 1, 120000),
    NONE("없음", 0, 0);

    private final String menu;
    private final int quantity;
    private final int limitPrice;

    GiftEvent(String menu, int quantity, int limitPrice) {
        this.menu = menu;
        this.quantity = quantity;
        this.limitPrice = limitPrice;
    }

    public String getMenu() {
        return menu;
    }

    public int getQuantity() {
        return quantity;
    }

    public static GiftEvent getGift(int totalPrice) {
        return Arrays.stream(values())
                .filter(gift -> totalPrice >= gift.limitPrice)
                .findFirst()
                .orElse(NONE);
    }

    public static boolean isGiftTarget(int totalPrice) {
        return totalPrice >= Constant.GIFT_LIMIT_PRICE;
    }

    public static String toString(GiftEvent gift) {
        if (gift.equals(NONE)) {
            return gift.getMenu();
        }

        return gift.getMenu() + " " + gift.getQuantity() + "개";
    }
}
