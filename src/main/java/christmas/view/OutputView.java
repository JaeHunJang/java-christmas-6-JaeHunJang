package christmas.view;

import christmas.config.Message;

public class OutputView {
    public static void printVisitDate(int date) {
        System.out.printf(Message.OUTPUT_VISIT_DATE, date);
    }
}
