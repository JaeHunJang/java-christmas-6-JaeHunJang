package christmas.controller;

import christmas.model.Order;
import christmas.model.VisitDate;
import christmas.view.InputView;

public class InputController {
    public static VisitDate setVisitDate() {
        try {
            return new VisitDate(InputView.readDate());
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return setVisitDate();
        }
    }

    public static Order setOrder() {
        try {
            return new Order(InputView.readOrder());
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return setOrder();
        }
    }
}
