package christmas.util.validator;

import christmas.config.Constant;
import christmas.config.Message;

public class VisitDateValidator {
    private final String date;

    public VisitDateValidator(String date) {
        this.date = date;
        validatePattern();
        validateDateStart();
        validateDateEnd();
    }

    private void validatePattern() {
        if (!date.matches(Constant.REGEX_DATE)) {
            throw new IllegalArgumentException(Message.ERROR_INPUT_DATE);
        }
    }

    private void validateDateStart() {
        if (Integer.parseInt(date) < Constant.DAY_START) {
            throw new IllegalArgumentException(Message.ERROR_INPUT_DATE);
        }
    }

    private void validateDateEnd() {
        if (Integer.parseInt(date) > Constant.DAY_END) {
            throw new IllegalArgumentException(Message.ERROR_INPUT_DATE);
        }
    }
}