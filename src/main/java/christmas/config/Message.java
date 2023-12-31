package christmas.config;

public class Message {
    public static final String INPUT_DATE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    public static final String INPUT_ORDER = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";

    public static final String OUTPUT_VISIT_DATE = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n";
    public static final String OUTPUT_MENU_TITLE = "\n<주문 메뉴>";
    public static final String OUTPUT_ITEM = "%s %d개%n";
    public static final String OUTPUT_WON = "%s원%n";
    public static final String OUTPUT_MINUS_WON = "-" + OUTPUT_WON;
    public static final String OUTPUT_TOTAL_PRICE = "%n<할인 전 총주문 금액>%n" + OUTPUT_WON;
    public static final String OUTPUT_GIFT_TITLE = "\n<증정 메뉴>";
    public static final String OUTPUT_PROMOTION_TITLE = "\n<혜택 내역>";
    public static final String OUTPUT_PROMOTION_ITEM = "%s: " + OUTPUT_MINUS_WON;
    public static final String OUTPUT_TOTAL_DISCOUNT = "%n<총혜택 금액>%n" + OUTPUT_WON;
    public static final String OUTPUT_PAYMENT_PRICE = "%n<할인 후 예상 결제 금액>%n" + OUTPUT_WON;
    public static final String OUTPUT_BADGE = "%n<12월 이벤트 배지>%n%s%n";
    public static final String OUTPUT_NONE = "없음";


    public static final String ERROR_MESSAGE_PREFIX = "[ERROR]";
    public static final String ERROR_INPUT_DATE = ERROR_MESSAGE_PREFIX + " 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    public static final String ERROR_INPUT_ORDER = ERROR_MESSAGE_PREFIX + " 유효하지 않은 주문입니다. 다시 입력해 주세요.";
}
