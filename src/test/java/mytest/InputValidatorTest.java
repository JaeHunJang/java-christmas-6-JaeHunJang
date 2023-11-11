package mytest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.Application;
import christmas.config.Message;
import christmas.model.VisitDate;
import christmas.util.validator.OrderValidator;
import christmas.util.validator.VisitDateValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest extends NsTest {
    @DisplayName("날짜 입력 검증 테스트")
    @ValueSource(strings = {"a","ㄱ","10a","ㄱ10","0","-1","32","99"})
    @ParameterizedTest
    void visitDateValidatorTest(String date) {
        assertThatThrownBy(() -> new VisitDateValidator(date))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Message.ERROR_INPUT_DATE);
    }

    @DisplayName("주문 입력 검증 테스트")
    @ValueSource(strings = {
            "해산물파스타-,2", "해산물파스타:2", "해산-1,물파스타-2", "해산물파스타-0", "0-해산물파스타",
            "해산-1,물파스타-2","해산물파스타-2-레드와인-1-초코케이크-1","해산물파스타,2,레드와인,1,초코케이크,1",
            "해산물파스타-2, 레드와인-1", "해산물파스타-2,해산물파스타-2"
    })
    @ParameterizedTest
    void orderValidatorTest(String order) {
        assertThatThrownBy(() -> new OrderValidator(order))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Message.ERROR_INPUT_ORDER);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}