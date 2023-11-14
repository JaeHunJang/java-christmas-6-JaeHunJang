package christmas.config;

import java.util.Arrays;

public enum Gift {
    CHAMPAGNE("샴페인", 1, 120000),
    NONE("없음", 0, 0);

    private final String menu;
    private final int quantity;
    private final int limitPrice;

    Gift(String menu, int quantity, int limitPrice) {
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

    public static Gift getGift(int totalPrice) {
        return Arrays.stream(values())
                .filter(gift -> totalPrice >= gift.limitPrice)
                .findFirst()
                .orElse(NONE);
    }
}
