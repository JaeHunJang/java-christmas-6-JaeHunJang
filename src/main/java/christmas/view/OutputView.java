package christmas.view;

import christmas.config.Message;

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
}
