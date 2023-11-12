package christmas.view;

import christmas.config.Message;
import christmas.util.Util;

import java.util.Map;

public class OutputView {
    public static void printVisitDate(int date) {
        System.out.printf(Message.OUTPUT_VISIT_DATE, date);
    }

    public static void printOrder(Map<String, Integer> order) {
        System.out.println(Message.OUTPUT_MENU_TITLE);
        order.forEach(OutputView::printMenu);
    }

    public static void printMenu(String menu, int quantity) {
        System.out.printf(Message.OUTPUT_MENU, menu, quantity);
    }

    public static void printTotalPrice(int totalPrice) {
        System.out.printf(Message.OUTPUT_TOTAL_PRICE, Util.formattingNumber(totalPrice));
    }
}
