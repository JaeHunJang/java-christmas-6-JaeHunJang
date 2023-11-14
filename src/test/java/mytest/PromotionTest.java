package mytest;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.Application;
import christmas.config.*;
import christmas.model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.EnumMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PromotionTest extends NsTest {

    @DisplayName("증정 이벤트 여부 테스트")
    @CsvSource(value = {
            "120000,25000", "100000,0", "0,0", "200000,25000", "119999,0"
    })
    @ParameterizedTest
    void giftTest(int totalPrice, int discount) {
        GiftEvent giftEvent = new GiftEvent(totalPrice);

        assertThat(giftEvent.getDiscountInfo().get(Event.GIFT))
                .isEqualTo(discount);
    }

    @DisplayName("평일 할인 테스트")
    @CsvSource(value = {
            "3,0,0", "5,1,2023", "7,3,6069", "15,2,0", "25,1,2023", "30,0,0"
    })
    @ParameterizedTest
    void weekdayTest(String visitDay, int quantity, int discount) {
        VisitDate visitDate = new VisitDate(visitDay);

        assertThat(new WeekdayEvent(visitDate.getWeekDay(), quantity).getDiscountInfo().getOrDefault(Event.WEEKDAY, 0))
                .isEqualTo(discount);
    }

    @DisplayName("주말 할인 테스트")
    @CsvSource(value = {
            "1,2,4046", "2,1,2023", "7,3,0", "15,2,4046", "29,1,2023", "30,0,0"
    })
    @ParameterizedTest
    void weekendTest(String visitDay, int quantity, int discount) {
        VisitDate visitDate = new VisitDate(visitDay);

        assertThat(new WeekendEvent(visitDate.getWeekDay(), quantity).getDiscountInfo().getOrDefault(Event.WEEKEND, 0))
                .isEqualTo(discount);
    }

    @DisplayName("특별 할인 테스트")
    @CsvSource(value = {
            "3:1000", "10:1000", "17:1000", "24:1000", "15:0", "25:1000", "31:1000", "1:0", "30:0"
    }, delimiter = ':')
    @ParameterizedTest
    void discountSpecialTest(String day, int discount) {
        VisitDate visitDate = new VisitDate(day);

        assertThat(new SpecialDayEvent(visitDate.getVisitDate()).getDiscountInfo().getOrDefault(Event.SPECIAL, 0))
                .isEqualTo(discount);
    }

    @DisplayName("디데이 할인 테스트")
    @CsvSource(value = {
            "1:1000", "3:1200", "10:1900", "17:2600", "24:3300", "25:3400", "31:0"
    }, delimiter = ':')
    @ParameterizedTest
    void discountDDayTest(String day, int discount) {
        VisitDate visitDate = new VisitDate(day);

        assertThat(new ChristmasDDayEvent(visitDate.getVisitDate()).getDiscountInfo().getOrDefault(Event.CHRISTMAS, 0))
                .isEqualTo(discount);
    }

    @DisplayName("총 혜택 금액 계산 테스트")
    @Test
    void totalDiscountTest() {
        Promotion promotion = new Promotion();
        Map<Event, Integer> discountInfo = new EnumMap<>(Event.class);
        discountInfo.put(Event.SPECIAL, 1000);
        discountInfo.put(Event.WEEKDAY, 6069);
        discountInfo.put(Event.WEEKEND, 2023);
        discountInfo.put(Event.CHRISTMAS, 2100);
        discountInfo.put(Event.GIFT, 25000);

        promotion.setDiscountInfo(discountInfo);

        assertThat(promotion.getTotalDiscount())
                .isEqualTo(36192);
    }

    @DisplayName("할인 후 결제금액 계산 테스트")
    @Test
    void paymentPriceTest() {
        Order order = new Order("티본스테이크-1,바비큐립-1,해산물파스타-2,크리스마스파스타-1,아이스크림-1"); //55000+54000+70000+25000+5000
        Promotion promotion = new Promotion();
        Map<Event, Integer> discountInfo = new EnumMap<>(Event.class);

        discountInfo.put(Event.SPECIAL, 1000);
        discountInfo.put(Event.WEEKDAY, 6069);
        discountInfo.put(Event.WEEKEND, 2023);
        discountInfo.put(Event.CHRISTMAS, 2100);
        discountInfo.put(Event.GIFT, 25000);

        promotion.setDiscountInfo(discountInfo);

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

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
