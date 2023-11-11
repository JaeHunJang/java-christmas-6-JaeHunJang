package christmas.controller;

import christmas.model.Order;
import christmas.model.VisitDate;

public class PromotionController {
    private final VisitDate visitDate;
    private final Order order;
    public PromotionController() {
        visitDate = InputController.setVisitDate();
        order = InputController.setOrder();
    }
}
