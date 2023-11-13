package christmas.model;

import christmas.util.validator.VisitDateValidator;

import java.time.LocalDate;
import java.util.Arrays;

public class VisitDate {
    public static final int YEAR = 2023;
    public static final int MONTH = 12;
    public static final int[] WEEKDAY = {1, 2, 3, 4, 7};
    public static final int[] WEEKEND = {5, 6};
    private final int visitDate;

    public VisitDate(String visitDate) {
        new VisitDateValidator(visitDate);
        this.visitDate = Integer.parseInt(visitDate);
    }

    public boolean isWeekday() {
        return Arrays.stream(WEEKDAY)
                .anyMatch(day -> day == getWeek());
    }

    public boolean isWeekend() {
        return Arrays.stream(WEEKEND)
                .anyMatch(day -> day == getWeek());
    }

    private int getWeek() {
        return LocalDate.of(YEAR, MONTH, visitDate)
                .getDayOfWeek()
                .getValue();
    }

    public int getVisitDate() {
        return visitDate;
    }
}
