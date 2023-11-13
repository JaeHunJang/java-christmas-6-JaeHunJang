package mytest;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.Application;
import christmas.config.Message;
import christmas.model.VisitDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
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
        runException("10", order);

        assertThat(output())
                .endsWith(Message.GIFT);
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

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
