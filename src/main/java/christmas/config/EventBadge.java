package christmas.config;

import java.util.Arrays;

public enum EventBadge {
    SANTA("산타", 20000),
    TREE("트리", 10000),
    STAR("별", 5000),
    NONE("없음", 0);

    private final String name;
    private final int limitPrice;

    EventBadge(String name, int limitPrice) {
        this.name = name;
        this.limitPrice = limitPrice;
    }

    public static String findBadgeByTotalDiscount(int totalDiscount) {
        return Arrays.stream(values())
                .filter(badge -> totalDiscount >= badge.limitPrice)
                .findFirst()
                .orElse(NONE)
                .name;
    }
}
