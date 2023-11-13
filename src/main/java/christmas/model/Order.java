package christmas.model;

import christmas.config.Constant;
import christmas.config.Menu;
import christmas.config.MenuType;
import christmas.config.Message;
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

    private int getTotalQuantity() {
        return order.values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public int getMenuQuantity(MenuType menuType) {
        return order.keySet()
                .stream()
                .filter(menu -> menu.getType() == menuType)
                .mapToInt(order::get)
                .sum();
    }

    public int getTotalPrice() {
        return order.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
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
