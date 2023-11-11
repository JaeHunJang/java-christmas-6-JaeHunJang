package christmas.model;

import christmas.config.Constant;
import christmas.util.validator.OrderValidator;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Order {
    private final Map<String, Integer> order;

    public Order(String order) {
        new OrderValidator(order);
        this.order = generateOrder(order);
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

    public Map<String, Integer> getOrder() {
        return order;
    }
}
