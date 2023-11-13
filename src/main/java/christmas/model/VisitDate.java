package christmas.model;

import christmas.util.validator.VisitDateValidator;

import java.time.LocalDate;
import java.util.Arrays;

public class VisitDate {
    private static final int YEAR = 2023;
    private static final int MONTH = 12;
    private static final int START_D_DAY = 1;
    private static final int END_D_DAY = 25;
    private static final int[] SPECIAL_DAYS = {3, 10, 17, 24, 25, 31};
    private static final int[] WEEKDAYS = {1, 2, 3, 4, 7};
    private static final int[] WEEKENDS = {5, 6};
    private final int visitDate;

    public VisitDate(String visitDate) {
        new VisitDateValidator(visitDate);
        this.visitDate = Integer.parseInt(visitDate);
    }

    public boolean isSpecialDay() {
        return Arrays.stream(SPECIAL_DAYS)
                .anyMatch(day -> day == visitDate);
    }

    public boolean isWeekday() {
        return Arrays.stream(WEEKDAYS)
                .anyMatch(day -> day == getWeek());
    }

    public boolean isWeekend() {
        return Arrays.stream(WEEKENDS)
                .anyMatch(day -> day == getWeek());
    }

    public int getDDayCount() {
        if (visitDate > END_D_DAY)
            return -1;
        return visitDate - START_D_DAY;
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
