package christmas.config;

import java.util.Arrays;

public enum Menu {

    APPETIZER_SOUP("양송이수프", 6000),
    APPETIZER_TAPAS("타파스", 5500),
    APPETIZER_SALAD("시저샐러드", 8000),

    MAIN_STAEK("티본스테이크", 55000),
    MAIN_BBQ("바비큐립", 54000),
    MAIN_SEAPASTA("해산물파스타", 35000),
    MAIN_CHRISTMASPASTA("크리스마스파스타", 25000),

    DESSERT_CAKE("초코케이크", 15000),
    DESSERT_ICECREAM("아이스크림", 5000),

    DRINK_COKE("제로콜라", 3000),
    DRINK_WINE("레드와인", 60000),
    DRINK_CHAMPAGNE("샴페인", 25000);

    private final String name;
    private final int price;

    Menu(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public static Menu getMenu(String name) {
        return Arrays.stream(Menu.values())
                .filter(menu -> menu.name.equals(name))
                .findFirst()
                .orElse(null);
    }
}
