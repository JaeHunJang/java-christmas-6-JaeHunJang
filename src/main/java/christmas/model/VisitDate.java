package christmas.model;

import christmas.util.validator.VisitDateValidator;

import java.time.LocalDate;

public class VisitDate {
    private static final int YEAR = 2023;
    private static final int MONTH = 12;

    private final int visitDate;

    public VisitDate(String visitDate) {
        new VisitDateValidator(visitDate);
        this.visitDate = Integer.parseInt(visitDate);
    }

    public int getWeekDay() {
        return LocalDate.of(YEAR, MONTH, visitDate)
                .getDayOfWeek()
                .getValue();
    }

    public int getVisitDate() {
        return visitDate;
    }
}
