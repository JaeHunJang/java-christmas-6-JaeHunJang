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

        print();
    }

    private void print() {
        OutputView.printVisitDate(visitDate.getVisitDate());
        OutputView.printOrder(order.getOrder());
        OutputView.printTotalPrice(order.getTotalPrice());
        OutputView.printGift(order.isGiftTarget());
    }
}
