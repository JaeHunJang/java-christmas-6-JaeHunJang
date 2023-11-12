package christmas.model;

import christmas.config.Constant;
import christmas.config.Menu;
import christmas.config.Message;
import christmas.util.validator.OrderValidator;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Order {
    private final Map<String, Integer> order;

    public Order(String order) {
        new OrderValidator(order);
        this.order = generateOrder(order);
        validateMaxOrderQuantity();
    }

    private Map<String, Integer> generateOrder(String order) {
        return Arrays.stream(order.split(Constant.MENU_DELIMITER))
                .map(menuItem -> menuItem.split(Constant.MENU_ITEM_DELIMITER))
                .collect(Collectors.toMap(this::getMenu, this::getQuantity));
    }

    private String getMenu(String[] menuItem) {
        return menuItem[0];
    }

    private Integer getQuantity(String[] menuItem) {
        return Integer.parseInt(menuItem[1]);
    }

    private void validateMaxOrderQuantity() {
        if (order.values().stream().mapToInt(Integer::intValue).sum() > Constant.MENU_MAX_QUANTITY)
            throw new IllegalArgumentException(Message.ERROR_INPUT_ORDER);
    }

    public int getTotalPrice() {
        return order.entrySet().stream()
                .mapToInt(entry -> Menu.getMenu(entry.getKey()).getPrice() * entry.getValue())
                .sum();
    }

    public Map<String, Integer> getOrder() {
        return order;
    }
}
