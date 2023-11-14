package christmas.model;

import christmas.config.Constant;
import christmas.config.Menu;
import christmas.config.MenuType;
import christmas.config.Message;
import christmas.util.Util;
import christmas.util.validator.OrderValidator;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Order {
    private final Map<Menu, Integer> order;

    public Order(String order) {
        new OrderValidator(order);
        this.order = generateOrder(order);
        validateMaxOrderQuantity();
        validateOnlyOrderDrink();
    }

    private Map<Menu, Integer> generateOrder(String order) {
        return Arrays.stream(order.split(Constant.MENU_DELIMITER))
                .map(menuItem -> menuItem.split(Constant.MENU_ITEM_DELIMITER))
                .collect(Collectors.toMap(this::getMenu, this::getQuantity));
    }

    private Menu getMenu(String[] menuItem) {
        return Menu.getMenu(menuItem[0]);
    }

    private Integer getQuantity(String[] menuItem) {
        return Integer.parseInt(menuItem[1]);
    }

    private void validateMaxOrderQuantity() {
        if (getTotalQuantity() > Constant.MENU_MAX_QUANTITY)
            throw new IllegalArgumentException(Message.ERROR_INPUT_ORDER);
    }

    private void validateOnlyOrderDrink() {
        if (getTotalQuantity() == getMenuQuantity(MenuType.DRINK))
            throw new IllegalArgumentException(Message.ERROR_INPUT_ORDER);
    }

    private int getTotalQuantity() {
        return Util.intStreamSum(order.values().stream());
    }

    public int getMenuQuantity(MenuType menuType) {
        return Util.intStreamSum(order.keySet()
                .stream()
                .filter(menu -> menu.getType() == menuType)
                .map(order::get));
    }

    public boolean isDiscountTarget() {
        return getTotalPrice() >= Constant.DISCOUNT_LIMIT_PRICE;
    }

    public int getTotalPrice() {
        return Util.intStreamSum(order.entrySet()
                .stream()
                .map(entry -> entry.getKey().getPrice() * entry.getValue()));
    }

    public Map<String, String> orderToString() {
        return order.entrySet()
                .stream()
                .collect(Collectors.toMap(
                        entry -> entry.getKey().getName(),
                        entry -> entry.getValue().toString()
                ));
    }
}
