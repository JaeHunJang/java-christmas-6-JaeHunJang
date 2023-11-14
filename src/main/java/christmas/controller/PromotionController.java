package christmas.controller;

import christmas.config.Constant;
import christmas.config.EventBadge;
import christmas.config.Gift;
import christmas.model.Order;
import christmas.model.Promotion;
import christmas.model.PromotionGenerator;
import christmas.model.VisitDate;
import christmas.view.OutputView;

public class PromotionController {
    private final VisitDate visitDate;
    private final Order order;
    private final Promotion promotion;

    public PromotionController() {
        visitDate = InputController.setVisitDate();
        order = InputController.setOrder();
        promotion = new PromotionGenerator(visitDate, order).getPromotion();
    }

    public void active() {
        print();
    }

    private int totalPrice() {
        return order.getTotalPrice();
    }

    private int totalDiscount() {
        return promotion.getTotalDiscount();
    }

    private boolean isEmptyPromotion() {
        return promotion.getTotalDiscount() == 0;
    }

    private void print() {
        OutputView.printVisitDate(visitDate.getVisitDate());
        OutputView.printOrder(order.getOrderList());
        OutputView.printTotalPrice(totalPrice());
        OutputView.printGift(Gift.getGift(totalPrice()));
        OutputView.printPromotion(isEmptyPromotion(), promotion.getPromotionList());
        OutputView.printTotalDiscount(totalDiscount() * Constant.MINUS);
        OutputView.printPaymentPrice(totalPrice() - promotion.getDiscount());
        OutputView.printBadge(EventBadge.findBadgeByTotalDiscount(totalDiscount()));
    }
}
