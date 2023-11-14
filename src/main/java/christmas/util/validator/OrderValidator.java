package christmas.util.validator;

import christmas.config.Constant;
import christmas.config.Menu;
import christmas.config.Message;
import christmas.util.Util;

import java.util.Arrays;
import java.util.List;

public class OrderValidator {
    private final String order;

    public OrderValidator(String order) {
        this.order = order;
        validatePattern();
        validateExistMenu();
        validateOrderQuantity();
        validateOrderDuplicate();
    }

    private void validatePattern() {
        if (!order.matches(Constant.REGEX_ORDER)) {
            throw new IllegalArgumentException(Message.ERROR_INPUT_ORDER);
        }
    }

    private void validateExistMenu() {
        generateMenuName().forEach(Menu::getMenu);
    }

    private void validateOrderQuantity() {
        if (!generateMenuQuantity().matches(Constant.REGEX_MIN_QUANTITY)) {
            throw new IllegalArgumentException(Message.ERROR_INPUT_ORDER);
        }
    }

    private void validateOrderDuplicate() {
        if (generateMenuName().size() != Util.distinctListSize(generateMenuName())) {
            throw new IllegalArgumentException(Message.ERROR_INPUT_ORDER);
        }
    }

    private List<String> generateMenuName() {
        return Util.stringToList(Util.changeRegexToBlank(order, Constant.REGEX_MENU_NAME), Constant.MENU_DELIMITER);
    }

    private String generateMenuQuantity() {
        return Util.changeRegexToBlank(order, Constant.REGEX_MENU_QUANTITY);
    }
}