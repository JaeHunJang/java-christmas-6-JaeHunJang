package christmas.util.validator;

import christmas.config.Constant;
import christmas.config.MenuType;
import christmas.config.Message;
import christmas.model.Order;

public class OrderGenerateAfterValidator {
    private final Order order;

    public OrderGenerateAfterValidator(final Order order) {
        this.order = order;

        validateMaxOrderQuantity();
        validateOnlyOrderDrink();
    }

    private void validateMaxOrderQuantity() {
        if (order.getTotalQuantity() > Constant.MENU_MAX_QUANTITY)
            throw new IllegalArgumentException(Message.ERROR_INPUT_ORDER);
    }

    private void validateOnlyOrderDrink() {
        if (order.getTotalQuantity() == order.getMenuQuantity(MenuType.DRINK))
            throw new IllegalArgumentException(Message.ERROR_INPUT_ORDER);
    }
}
