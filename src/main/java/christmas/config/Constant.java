package christmas.config;

public class Constant {
    public static final String REGEX_DATE = "\\d+";
    public static final int VISIT_DATE_START = 1;
    public static final int VISIT_DATE_END = 31;

    public static final String MENU_DELIMITER = ",";
    public static final String MENU_ITEM_DELIMITER = "-";
    public static final String REGEX_ORDER = "^([가-힣]+-\\d+)(,([가-힣]+-\\d+))*$";
    public static final String REGEX_MENU_NAME = "[^가-힣,]+";
    public static final String REGEX_MENU_QUANTITY = "[^\\d,]+";
    public static final String REGEX_MIN_QUANTITY = "^[1-9]\\d*(,[1-9]\\d*)*$";
    public static final int MENU_MAX_QUANTITY = 20;

    public static final int DISCOUNT_LIMIT_PRICE = 10000;
    public static final int GIFT_LIMIT_PRICE = 120000;
    public static final int DISCOUNT_WEEK_PRICE = 2023;
    public static final int DISCOUNT_SPECIAL = 1000;
    public static final int DISCOUNT_CHRISTMAS = 1000;
    public static final int DISCOUNT_CHRISTMAS_UNIT = 100;
    public static final int MINUS = -1;
}