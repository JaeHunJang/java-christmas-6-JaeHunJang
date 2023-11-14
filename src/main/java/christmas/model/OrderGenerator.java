package christmas.model;

import christmas.config.Constant;
import christmas.config.Menu;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderGenerator {
    private final String input;

    OrderGenerator(String input) {
        this.input = input;
    }

    public Map<Menu, Integer> generateOrder() {
        return Arrays.stream(input.split(Constant.MENU_DELIMITER))
                .map(menuItem -> menuItem.split(Constant.MENU_ITEM_DELIMITER))
                .collect(Collectors.toMap(
                        this::getMenu,
                        this::getQuantity)
                );
    }

    private Menu getMenu(String[] menuItem) {
        return Menu.getMenu(menuItem[0]);
    }

    private Integer getQuantity(String[] menuItem) {
        return Integer.parseInt(menuItem[1]);
    }
}
