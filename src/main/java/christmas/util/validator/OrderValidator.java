package christmas.util.validator;

import christmas.config.Constant;
import christmas.config.Message;
import christmas.util.Util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OrderValidator {
    private final String order;
    private final Set<String> menuAppetizer = Set.of("양송이수프", "타파스", "시저샐러드");
    private final Set<String> menuMain = Set.of("티본스테이크", "바비큐립", "해산물파스타", "크리스마스파스타");
    private final Set<String> menuDessert = Set.of("초코케이크", "아이스크림");
    private final Set<String> menuDrink = Set.of("제로콜라", "레드와인", "샴페인");

    private final Set<String> menuAll = new HashSet<>();

    public OrderValidator(String order) {
        this.order = order;
        menuAll.addAll(menuAppetizer);
        menuAll.addAll(menuMain);
        menuAll.addAll(menuDessert);
        menuAll.addAll(menuDrink);

        validatePattern();
        validateContainMenu();
        validateOrderQuantity();
        validateOrderDuplicate();
    }

    private void validatePattern() {
        if (!order.matches(Constant.REGEX_ORDER)) {
            throw new IllegalArgumentException(Message.ERROR_INPUT_ORDER);
        }
    }

    private void validateContainMenu() {
        if (!menuAll.containsAll(generateMenuName())) {
            throw new IllegalArgumentException(Message.ERROR_INPUT_ORDER);
        }
    }

    private void validateOrderQuantity() {
        if (!generateMenuQuantity().matches(Constant.REGEX_MIN_QUANTITY)) {
            throw new IllegalArgumentException(Message.ERROR_INPUT_ORDER);
        }
    }

    private void validateOrderDuplicate() {
        if (generateMenuName().size() != generateMenuName().stream().distinct().count())
            throw new IllegalArgumentException(Message.ERROR_INPUT_ORDER);
    }

    private List<String> generateMenuName() {
        return Util.stringToList(order.replaceAll(Constant.REGEX_MENU_NAME, ""), Constant.MENU_DELIMITER);
    }

    private String generateMenuQuantity() {
        return order.replaceAll(Constant.REGEX_MENU_QUANTITY, "");
    }
}