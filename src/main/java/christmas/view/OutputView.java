package christmas.view;

import christmas.config.Gift;
import christmas.config.Message;
import christmas.util.Util;

import java.util.Map;

public class OutputView {
    public static void printVisitDate(int date) {
        System.out.printf(Message.OUTPUT_VISIT_DATE, date);
    }

    public static void printOrder(Map<String, Integer> order) {
        System.out.println(Message.OUTPUT_MENU_TITLE);
        order.forEach((menu, quantity) ->
                System.out.printf(Message.OUTPUT_ITEM, menu, quantity)
        );
    }

    public static void printTotalPrice(int totalPrice) {
        System.out.printf(Message.OUTPUT_TOTAL_PRICE, Util.formattingNumber(totalPrice));
    }

    public static void printGift(Gift gift) {
        System.out.println(Message.OUTPUT_GIFT_TITLE);
        if (gift.equals(Gift.NONE)) {
            printNone();
            return;
        }
        System.out.printf(Message.OUTPUT_ITEM, gift.getMenu(), gift.getQuantity());
    }

    public static void printPromotion(boolean isEmptyPromotion, Map<String, Integer> promotion) {
        System.out.println(Message.OUTPUT_PROMOTION_TITLE);
        if (isEmptyPromotion) {
            printNone();
        }
        promotion.forEach((event, discount) ->
                System.out.printf(Message.OUTPUT_PROMOTION_ITEM, event, Util.formattingNumber(discount))
        );
    }

    public static void printTotalDiscount(int totalDiscount) {
        System.out.printf(Message.OUTPUT_TOTAL_DISCOUNT, Util.formattingNumber(totalDiscount));
    }

    public static void printPaymentPrice(int paymentPrice) {
        System.out.printf(Message.OUTPUT_PAYMENT_PRICE, Util.formattingNumber(paymentPrice));
    }

    public static void printBadge(String badge) {
        System.out.printf(Message.OUTPUT_BADGE, badge);
    }

    public static void printNone() {
        System.out.println(Message.OUTPUT_NONE);
    }
}
