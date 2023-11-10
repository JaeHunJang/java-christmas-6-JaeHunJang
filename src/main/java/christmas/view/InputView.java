package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.config.Message;

public class InputView {
    public static String readDate() {
        System.out.println(Message.INPUT_DATE);
        return Console.readLine();
    }

}