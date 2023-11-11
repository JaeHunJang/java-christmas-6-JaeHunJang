package christmas.config;

public class Message {
    public static final String INPUT_DATE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    public static final String INPUT_ORDER = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";


    public static final String ERROR_MESSAGE_PREFIX = "[ERROR]";
    public static final String ERROR_INPUT_DATE = ERROR_MESSAGE_PREFIX + " 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    public static final String ERROR_INPUT_ORDER = ERROR_MESSAGE_PREFIX + " 유효하지 않은 주문입니다. 다시 입력해 주세요.";
}
