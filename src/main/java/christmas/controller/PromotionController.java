package christmas.controller;

import christmas.model.Order;
import christmas.model.Promotion;
import christmas.model.VisitDate;
import christmas.view.OutputView;

public class PromotionController {
    private final VisitDate visitDate;
    private final Order order;
    private final Promotion promotion;
    public PromotionController() {
        visitDate = InputController.setVisitDate();
        order = InputController.setOrder();
        promotion = new Promotion();

        discount();
        print();
    }

    private void print() {
        OutputView.printVisitDate(visitDate.getVisitDate());
        OutputView.printOrder(order.orderToString());
        OutputView.printTotalPrice(order.getTotalPrice());
        OutputView.printGift(promotion.hasGift());
    }

    private void discount() {
        promotion.discountGift(order.getTotalPrice());
    }
}
