package christmas.view;

import christmas.config.Message;
import christmas.util.Util;

import java.util.Map;

public class OutputView {
    public static void printVisitDate(int date) {
        System.out.printf(Message.OUTPUT_VISIT_DATE, date);
    }

    public static void printOrder(Map<String, String> order) {
        System.out.println(Message.OUTPUT_MENU_TITLE);
        order.forEach((menu, quantity) ->
                System.out.printf(Message.OUTPUT_MENU, menu, quantity)
        );
    }

    public static void printTotalPrice(int totalPrice) {
        System.out.printf(Message.OUTPUT_TOTAL_PRICE, Util.formattingNumber(totalPrice));
    }

    public static void printGift(String gift) {
        System.out.printf(Message.OUTPUT_GIFT, gift);
    }

    public static void printPromotion(boolean isEventTarget, Map<String, Integer> promotion) {
        System.out.println(Message.OUTPUT_PROMOTION_TITLE);
        if (!isEventTarget) {
            System.out.println(Message.OUTPUT_NONE);
        }
        promotion.forEach((event, discount) ->
                System.out.printf(Message.OUTPUT_PROMOTION_ITEM, event, discount)
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
}
