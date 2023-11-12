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

}