package mytest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.Application;
import christmas.config.Message;
import christmas.model.Order;
import christmas.model.VisitDate;
import christmas.util.validator.OrderValidator;
import christmas.util.validator.VisitDateValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest extends NsTest {
    @DisplayName("날짜 입력 검증 테스트")
    @ValueSource(strings = {"a", "ㄱ", "10a", "ㄱ10", "0", "-1", "32", "99"})
    @ParameterizedTest
    void visitDateValidatorTest(String date) {
        assertThatThrownBy(() -> new VisitDateValidator(date))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Message.ERROR_INPUT_DATE);
    }

    @DisplayName("날짜 저장 테스트")
    @ValueSource(strings = {"a", "ㄱ", "10a", "ㄱ10", "0", "-1", "32", "99"})
    @ParameterizedTest
    void visitDateTest(String date) {
        runException(date);

        assertThat(output()).contains(
                Message.ERROR_INPUT_DATE
        ).endsWith(Message.INPUT_DATE);
    }

    @DisplayName("주문 입력 검증 테스트")
    @ValueSource(strings = {
            "해산물파스타-,2", "해산물파스타:2", "해산-1,물파스타-2", "해산물파스타-0", "0-해산물파스타",
            "해산-1,물파스타-2", "해산물파스타-2-레드와인-1-초코케이크-1", "해산물파스타,2,레드와인,1,초코케이크,1",
            "해산물파스타-2, 레드와인-1", "해산물파스타-2,해산물파스타-2"
    })
    @ParameterizedTest
    void orderValidatorTest(String order) {
        assertThatThrownBy(() -> new OrderValidator(order))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Message.ERROR_INPUT_ORDER);
    }

    @DisplayName("주문 저장 테스트")
    @ValueSource(strings = {
            "해산물파스타-,2", "해산물파스타:2", "해산-1,물파스타-2", "해산물파스타-0", "0-해산물파스타",
            "해산-1,물파스타-2", "해산물파스타-2-레드와인-1-초코케이크-1", "해산물파스타,2,레드와인,1,초코케이크,1",
            "해산물파스타-2, 레드와인-1", "해산물파스타-2,해산물파스타-2"
    })
    @ParameterizedTest
    void orderTest(String order) {
        runException("10", order);

        assertThat(output()).contains(
                Message.ERROR_INPUT_ORDER
        ).endsWith(Message.INPUT_ORDER);
    }

    @DisplayName("최대 주문 수량 테스트")
    @ValueSource(strings = {
            "해산물파스타-19,타파스-2", "해산물파스타-21",
            "양송이수프-10,타파스-1,시저샐러드-1,티본스테이크-1,바비큐립-1,해산물파스타-1,크리스마스파스타-1,초코케이크-1,아이스크림-1,제로콜라-1,레드와인-1,샴페인-1"
    })
    @ParameterizedTest
    void maxOrderQuantityTest(String order) {
        runException("10", order);

        assertThat(output()).contains(
                Message.ERROR_INPUT_ORDER
        ).endsWith(Message.INPUT_ORDER);
    }

    @DisplayName("음료만 주문 테스트")
    @CsvSource(value = {
            "레드와인-1,타파스-2:true",
            "제로콜라-1,레드와인-1,샴페인-1:false",
            "레드와인-1:false",
            "샴페인-1:false",
            "제로콜라-1:false",
            "해산물파스타-1,제로콜라-1:true"
    }, delimiter = ':'
    )
    @ParameterizedTest
    void onlyOrderDrinkTest(String order, boolean success) {
        runException("10", order);

        assertThat(output()).contains(
                success ? "" : Message.ERROR_INPUT_ORDER
        );
    }

    @DisplayName("총 금액 테스트")
    @CsvSource(value = {
            "해산물파스타-2,레드와인-2:190000",
            "타파스-1,시저샐러드-1,티본스테이크-1,크리스마스파스타-1,아이스크림-1,제로콜라-2:104500",
            "샴페인-2,해산물파스타-1,바비큐립-1,양송이수프-1:145000"
    }, delimiter = ':'
    )
    @ParameterizedTest
    void orderTotalPriceTest(String order, int price) {
        assertThat(new Order(order).getTotalPrice())
                .isEqualTo(price);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}