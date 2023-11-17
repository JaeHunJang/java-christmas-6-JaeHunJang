package christmas.model;

import christmas.config.MenuType;

public class PromotionGenerator {
    public static final int DISCOUNT_LIMIT_PRICE = 10000;

    private final Promotion promotion;

    public PromotionGenerator(final VisitDate visitDate, final Order order) {
        this.promotion = new Promotion();

        if (isDiscountTarget(order.getTotalPrice())) {
            christmasDDayEvent(visitDate.getVisitDate());
            weekdayEvent(visitDate.getWeekDay(), order.getMenuQuantity(MenuType.DESSERT));
            weekendEvent(visitDate.getWeekDay(), order.getMenuQuantity(MenuType.MAIN));
            specialDayEvent(visitDate.getVisitDate());
            giftEvent(order.getTotalPrice());
        }
    }

    private boolean isDiscountTarget(int totalPrice) {
        return totalPrice >= DISCOUNT_LIMIT_PRICE;
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

    public Promotion getPromotion() {
        return promotion;
    }
}
