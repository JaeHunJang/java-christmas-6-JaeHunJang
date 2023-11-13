package christmas.controller;

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
