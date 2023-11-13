package christmas.model;

import christmas.util.validator.VisitDateValidator;

import java.time.LocalDate;
import java.util.Arrays;

public class VisitDate {
    private static final int YEAR = 2023;
    private static final int MONTH = 12;
    private static final int MAX_DDAY = 25;
    private static final int[] SPECIAL_DAY = {3, 10, 17, 24, 25, 31};
    private static final int[] WEEKDAY = {1, 2, 3, 4, 7};
    private static final int[] WEEKEND = {5, 6};
    private final int visitDate;

    public VisitDate(String visitDate) {
        new VisitDateValidator(visitDate);
        this.visitDate = Integer.parseInt(visitDate);
    }

    public boolean isSpecialDay() {
        return Arrays.stream(SPECIAL_DAY)
                .anyMatch(day -> day == visitDate);
    }

    public boolean isWeekday() {
        return Arrays.stream(WEEKDAY)
                .anyMatch(day -> day == getWeek());
    }

    public boolean isWeekend() {
        return Arrays.stream(WEEKEND)
                .anyMatch(day -> day == getWeek());
    }

    public int getDDayCount() {
        if (visitDate > MAX_DDAY)
            return -1;
        return visitDate -1;
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
