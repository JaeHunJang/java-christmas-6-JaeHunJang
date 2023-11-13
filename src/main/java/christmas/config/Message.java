package christmas.config;

public class Message {
    public static final String INPUT_DATE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    public static final String INPUT_ORDER = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";

    public static final String OUTPUT_VISIT_DATE = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n";
    public static final String OUTPUT_MENU_TITLE = "\n<주문 메뉴>";
    public static final String OUTPUT_MENU = "%s %s개%n";
    public static final String OUTPUT_TOTAL_PRICE = "%n<할인 전 총주문 금액>%n%s원%n";
    public static final String OUTPUT_GIFT = "%n<증정 메뉴>%n%s%n";
    public static final String OUTPUT_PROMOTION_TITLE = "\n<혜택 내역>";
    public static final String OUTPUT_PROMOTION_ITEM = "%s: -%s원%n";
    public static final String GIFT = "샴페인 1개";
    public static final String NONE = "없음";


    public static final String ERROR_MESSAGE_PREFIX = "[ERROR]";
    public static final String ERROR_INPUT_DATE = ERROR_MESSAGE_PREFIX + " 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    public static final String ERROR_INPUT_ORDER = ERROR_MESSAGE_PREFIX + " 유효하지 않은 주문입니다. 다시 입력해 주세요.";
}
