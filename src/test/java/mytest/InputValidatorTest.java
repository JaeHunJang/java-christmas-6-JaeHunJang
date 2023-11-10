package mytest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import christmas.config.Message;
import christmas.util.validator.MenuValidator;
import christmas.util.validator.VisitDateValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {
    @DisplayName("날짜 입력 검증 테스트")
    @ValueSource(strings = {"a","ㄱ","10a","ㄱ10","0","-1","32","99"})
    @ParameterizedTest
    void visitDateValidatorTest(String date) {
        assertThatThrownBy(() ->
                new VisitDateValidator(date)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Message.ERROR_INPUT_DATE);
    }
}