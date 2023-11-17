package christmas.config;

import java.util.Arrays;

public enum Menu {
    SOUP(MenuType.APPETIZER, "양송이수프", 6000),
    TAPAS(MenuType.APPETIZER, "타파스", 5500),
    SALAD(MenuType.APPETIZER, "시저샐러드", 8000),
    STAEK(MenuType.MAIN, "티본스테이크", 55000),
    BBQ(MenuType.MAIN, "바비큐립", 54000),
    SEAPASTA(MenuType.MAIN, "해산물파스타", 35000),
    CHRISTMASPASTA(MenuType.MAIN, "크리스마스파스타", 25000),
    CAKE(MenuType.DESSERT, "초코케이크", 15000),
    ICECREAM(MenuType.DESSERT, "아이스크림", 5000),
    COKE(MenuType.DRINK, "제로콜라", 3000),
    WINE(MenuType.DRINK, "레드와인", 60000),
    CHAMPAGNE(MenuType.DRINK, "샴페인", 25000);

    private final MenuType type;
    private final String name;
    private final int price;

    Menu(MenuType type, String name, int price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    public MenuType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public static Menu getMenu(String name) {
        return Arrays.stream(Menu.values())
                .filter(menu -> menu.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(Message.ERROR_INPUT_ORDER));
    }
}