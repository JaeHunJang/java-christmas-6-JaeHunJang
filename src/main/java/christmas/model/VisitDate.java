package christmas.model;

import christmas.config.Constant;
import christmas.util.validator.VisitDateValidator;

import java.time.LocalDate;

public class VisitDate {
    private final int visitDate;

    public VisitDate(String visitDate) {
        new VisitDateValidator(visitDate);
        this.visitDate = Integer.parseInt(visitDate);
    }

    public int getWeekDay() {
        return LocalDate.of(Constant.YEAR, Constant.MONTH, visitDate)
                .getDayOfWeek()
                .getValue();
    }

    public int getVisitDate() {
        return visitDate;
    }
}
