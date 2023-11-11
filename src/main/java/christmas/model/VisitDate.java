package christmas.model;

import christmas.util.validator.VisitDateValidator;

public class VisitDate {
    private final int visitDate;

    public VisitDate(String visitDate) {
        new VisitDateValidator(visitDate);
        this.visitDate = Integer.parseInt(visitDate);
    }

    public int getVisitDate() {
        return visitDate;
    }
}
