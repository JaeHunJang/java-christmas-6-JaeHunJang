package christmas.config;

public enum MenuType {
    APPETIZER,
    MAIN,
    DESSERT,
    DRINK;

    public String getType() {
        return super.name().toLowerCase();
    }
}
