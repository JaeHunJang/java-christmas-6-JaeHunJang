package christmas.model;

import christmas.config.Menu;
import christmas.config.MenuType;
import christmas.util.Util;
import christmas.util.validator.OrderGenerateAfterValidator;
import christmas.util.validator.OrderGenerateBeforeValidator;

import java.util.Map;
import java.util.stream.Collectors;

public class Order {
    private final Map<Menu, Integer> order;

    public Order(String order) {
        new OrderGenerateBeforeValidator(order);
        this.order = new OrderGenerator(order).generateOrder();
        new OrderGenerateAfterValidator(this);
    }

    public int getTotalQuantity() {
        return Util.intStreamSum(order.values().stream());
    }

    public int getMenuQuantity(MenuType menuType) {
        return Util.intStreamSum(order.keySet()
                .stream()
                .filter(menu -> menu.getType() == menuType)
                .map(order::get));
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
