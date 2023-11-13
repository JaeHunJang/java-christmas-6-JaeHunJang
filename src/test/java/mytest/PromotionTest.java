package mytest;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.Application;
import christmas.config.*;
import christmas.model.Order;
import christmas.model.Promotion;
import christmas.model.VisitDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PromotionTest extends NsTest {

    @DisplayName("증정 이벤트 여부 테스트")
    @ValueSource(strings = {
            "해산물파스타-2,레드와인-2",
            "해산물파스타-10,타파스-2","해산물파스타-20",
            "양송이수프-9,타파스-1,시저샐러드-1,티본스테이크-1,바비큐립-1,해산물파스타-1,크리스마스파스타-1,초코케이크-1,아이스크림-1,제로콜라-1,레드와인-1,샴페인-1"
    })
    @ParameterizedTest
    void giftTest(String order) {
        Promotion promotion = new Promotion();
        promotion.discountGift(new Order(order).getTotalPrice());

        assertThat(promotion.getPromotion().get(Event.GIFT))
                .isEqualTo(Menu.CHAMPAGNE.getPrice());
    }

    @DisplayName("평일 테스트")
    @ValueSource(strings = {
            "3", "5", "7", "11", "25", "28"
    })
    @ParameterizedTest
    void weekdayTest(String visitDay) {
        VisitDate visitDate = new VisitDate(visitDay);

        assertThat(visitDate.isWeekday())
                .isTrue();
    }

    @DisplayName("주말 테스트")
    @ValueSource(strings = {
            "1", "2", "15", "29", "30"
    })
    @ParameterizedTest
    void weekendTest(String visitDay) {
        VisitDate visitDate = new VisitDate(visitDay);

        assertThat(visitDate.isWeekend())
                .isTrue();
    }

    @DisplayName("평일 할인 테스트")
    @CsvSource(value = {
            "초코케이크-1,아이스크림-1:4046",
            "아이스크림-1:2023",
            "초코케이크-1:2023",
            "초코케이크-3,아이스크림-1:8092",
            }, delimiter = ':'
    )
    @ParameterizedTest
    void discountWeekdayTest(String order, int discountPrice) {
        Promotion promotion = new Promotion();
        promotion.discountWeekday(new Order(order).getMenuQuantity(MenuType.DESSERT));

        assertThat(promotion.getPromotion().get(Event.WEEKDAY))
                .isEqualTo(discountPrice);
    }

    @DisplayName("주말 할인 테스트")
    @CsvSource(value = {
            "티본스테이크-1,바비큐립-1:4046",
            "바비큐립-1:2023",
            "티본스테이크-1,바비큐립-1,해산물파스타-2,크리스마스파스타-1,아이스크림-1:10115",
            "해산물파스타-3,시저샐러드-1,초코케이크-1:6069",
    }, delimiter = ':'
    )
    @ParameterizedTest
    void discountWeekendTest(String order, int discountPrice) {
        Promotion promotion = new Promotion();
        promotion.discountWeekend(new Order(order).getMenuQuantity(MenuType.MAIN));

        assertThat(promotion.getPromotion().get(Event.WEEKEND))
                .isEqualTo(discountPrice);
    }

    @DisplayName("특별 할인 테스트")
    @ValueSource(strings = {
            "3", "10", "17", "24", "25", "31"
    })
    @ParameterizedTest
    void discountSpecialest(String day) {
        Promotion promotion = new Promotion();
        if (new VisitDate(day).isSpecialDay())
            promotion.discountSpecial();

        assertThat(promotion.getPromotion().get(Event.SPECIAL))
                .isEqualTo(1000);
    }

    @DisplayName("디데이 할인 테스트")
    @CsvSource(value = {
            "1:1000", "3:1200", "10:1900", "17:2600", "24:3300", "25:3400", "31:0"
    }, delimiter = ':')
    @ParameterizedTest
    void discountDDaytest(String day, int discount) {
        VisitDate visitDate = new VisitDate(day);
        Promotion promotion = new Promotion();
        promotion.discountDDay(visitDate.getDDayCount());

        assertThat(promotion.getPromotion().get(Event.CHRISTMAS))
                .isEqualTo(discount);
    }

    @DisplayName("총 혜택 금액 계산 테스트")
    @Test
    void totalDiscountTest() {
        Promotion promotion = new Promotion();
        promotion.discountSpecial(); //1000
        promotion.discountWeekday(3); //6069
        promotion.discountWeekend(1); //2023
        promotion.discountDDay(11); //2100
        promotion.discountGift(120000); //25000

        assertThat(promotion.getTotalDiscount())
                .isEqualTo(36192);
    }

    @DisplayName("할인 후 결제금액 계산 테스트")
    @Test
    void paymentPriceTest() {
        Order order = new Order("티본스테이크-1,바비큐립-1,해산물파스타-2,크리스마스파스타-1,아이스크림-1"); //55000+54000+70000+25000+5000
        Promotion promotion = new Promotion();
        promotion.discountSpecial(); //1000
        promotion.discountWeekday(3); //6069
        promotion.discountWeekend(1); //2023
        promotion.discountDDay(11); //2100
        promotion.discountGift(120000); //25000 - 포함X

        assertThat(promotion.getDiscount())
                .isEqualTo(11192);

        assertThat(order.getTotalPrice() - promotion.getDiscount())
                .isEqualTo(197808);
    }

    @DisplayName("배지 테스트")
    @CsvSource(value = {
            "0:없음", "4999:없음",
            "5000:별", "9999:별",
            "10000:트리", "19999:트리",
            "20000:산타", "200000:산타"
    }, delimiter = ':')
    @ParameterizedTest
    void badgeTest(int totalDiscount, String badge) {
        assertThat(EventBadge.findBadgeByTotalDiscount(totalDiscount))
                .isEqualTo(badge);
    }


    @DisplayName("할인 대상자 테스트")
    @CsvSource(value = {
            "티본스테이크-1,바비큐립-1,해산물파스타-2,크리스마스파스타-1,아이스크림-1:true",
            "아이스크림-1:false",
            "타파스-1:false",
            "아이스크림-1,제로콜라-1:false",
    }, delimiter = ':')
    @ParameterizedTest
    void eventTargetTest(String order, boolean isDiscountTarget) {

        assertThat(new Order(order).isDiscountTarget())
                .isEqualTo(isDiscountTarget);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
