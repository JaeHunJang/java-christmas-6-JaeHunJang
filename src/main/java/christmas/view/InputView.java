package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.config.Message;

public class InputView {
    public static String readDate() {
        System.out.println(Message.INPUT_DATE);
        return Console.readLine();
    }

    public static String readOrder() {
        System.out.println(Message.INPUT_ORDER);
        return Console.readLine();
    }
}