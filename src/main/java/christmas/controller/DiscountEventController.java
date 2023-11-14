package christmas.controller;

import christmas.config.Constant;
import christmas.config.MenuType;
import christmas.model.*;

public class DiscountEventController {
    private final Promotion promotion;

    DiscountEventController(final VisitDate visitDate, final Order order) {
        this.promotion = new Promotion();

        if (isDiscountTarget(order.getTotalPrice())) {
            christmasDDayEvent(visitDate.getVisitDate());
            weekdayEvent(visitDate.getWeekDay(), order.getMenuQuantity(MenuType.DESSERT));
            weekendEvent(visitDate.getWeekDay(), order.getMenuQuantity(MenuType.MAIN));
            specialDayEvent(visitDate.getVisitDate());
            giftEvent(order.getTotalPrice());
        }
    }
    private void christmasDDayEvent(int visitDate) {
        promotion.setDiscountInfo(new ChristmasDDayEvent(visitDate).getDiscountInfo());
    }

    private void weekdayEvent(int weekday, int dessertQuantity) {
        promotion.setDiscountInfo(new WeekdayEvent(weekday, dessertQuantity).getDiscountInfo());
    }

    private void weekendEvent(int weekday, int mainQuantity) {
        promotion.setDiscountInfo(new WeekendEvent(weekday, mainQuantity).getDiscountInfo());
    }

    private void specialDayEvent(int visitDate) {
        promotion.setDiscountInfo(new SpecialDayEvent(visitDate).getDiscountInfo());
    }

    private void giftEvent(int totalPrice) {
        promotion.setDiscountInfo(new GiftEvent(totalPrice).getDiscountInfo());
    }

    public static boolean isDiscountTarget(int totalPrice) {
        return totalPrice >= Constant.DISCOUNT_LIMIT_PRICE;
    }

    public Promotion getPromotion() {
        return promotion;
    }
}
