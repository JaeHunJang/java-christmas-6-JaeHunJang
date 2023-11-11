package christmas.controller;

import christmas.model.Order;
import christmas.model.VisitDate;
import christmas.view.OutputView;

public class PromotionController {
    private final VisitDate visitDate;
    private final Order order;
    public PromotionController() {
        visitDate = InputController.setVisitDate();
        order = InputController.setOrder();

        OutputView.printVisitDate(visitDate.getVisitDate());
    }
}
