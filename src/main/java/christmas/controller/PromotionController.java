package christmas.controller;

import christmas.config.Constant;
import christmas.config.EventBadge;
import christmas.config.Gift;
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

        promotion = new EventController(visitDate, order).getPromotion();

        print();
    }

    private int totalPrice() {
        return order.getTotalPrice();
    }

    private int totalDiscount() {
        return promotion.getTotalDiscount();
    }

    private int discount() {
        return promotion.getDiscount();
    }

    private void print() {
        OutputView.printVisitDate(visitDate.getVisitDate());
        OutputView.printOrder(order.orderToString());
        OutputView.printTotalPrice(totalPrice());
        OutputView.printGift(Gift.getGift(totalPrice()));
        OutputView.printPromotion(EventController.isDiscountTarget(totalPrice()), promotion.getPromotionList());
        OutputView.printTotalDiscount(totalDiscount() * Constant.MINUS);
        OutputView.printPaymentPrice(totalPrice() - discount());
        OutputView.printBadge(EventBadge.findBadgeByTotalDiscount(totalDiscount()));
    }
}
