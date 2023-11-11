package christmas.controller;

import christmas.model.VisitDate;

public class PromotionController {
    private final VisitDate visitDate;
    public PromotionController() {
        visitDate = InputController.setVisitDate();
    }
}
