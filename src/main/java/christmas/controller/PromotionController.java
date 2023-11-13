package christmas.controller;

import christmas.config.Constant;
import christmas.config.EventBadge;
import christmas.config.MenuType;
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
        OutputView.printPromotion(promotion.getPromotionList());
        OutputView.printTotalDiscount(promotion.getTotalDiscount() * Constant.MINUS);
        OutputView.printPaymentPrice(order.getTotalPrice(), promotion.getDiscount());
        OutputView.printBadge(EventBadge.findBadgeByTotalDiscount(promotion.getTotalDiscount()));
    }

    private void discount() {
        promotion.discountDDay(visitDate.getDDayCount());
        if (visitDate.isWeekday()) {
            promotion.discountWeekday(order.getMenuQuantity(MenuType.DESSERT));
        }
        if (visitDate.isWeekend()) {
            promotion.discountWeekend(order.getMenuQuantity(MenuType.MAIN));
        }
        if (visitDate.isSpecialDay()) {
            promotion.discountSpecial();
        }
        promotion.discountGift(order.getTotalPrice());
    }
}
