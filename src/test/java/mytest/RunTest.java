package mytest;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RunTest extends NsTest {
    @DisplayName("전체 테스트")
    @CsvSource(value = {
            //크리스마스디데이할인,평일할인,주말할인,특별할인,증정이벤트
            "26:타파스-1:26일:5,500:없음:0원:5,500:없음", //없음
            "22:양송이수프-2,티본스테이크-1,바비큐립-1,크리스마스파스타-1,아이스크림-3,제로콜라-2:22일:167,000:샴페인 1개:34,169:157,831:산타", //3100,-,6069,-,25000
            "31:양송이수프-19:31일:114,000:없음:1,000:113,000:없음", //-,-,-,1000,-
            "15:초코케이크-10,레드와인-10:15일:750,000:샴페인 1개:27,400:747,600:산타", //:2400,-,-,-,25000
            "28:아이스크림-7:28일:35,000:없음:14,161:20,839:트리", //:-,14161,-,-,-
            "27:시저샐러드-5,샴페인-12:27일:340,000:샴페인 1개:25,000:340,000:산타", //:-,-,-,-,25000
            "7:아이스크림-18:7일:90,000:없음:38,014:51,986:산타", //:1600,36414,-,-,-
            "25:아이스크림-2,티본스테이크-1:25일:65,000:없음:8,446:56,554:별", //:3400,4046,-,1000,-
            "17:아이스크림-4,크리스마스파스타-2:17일:70,000:없음:11,692:58,308:트리" //:2600,8092,-,1000,-
    }, delimiter = ':')
    @ParameterizedTest
    void applicationTest(String date, String order, String printDate, String totalPrice, String gift, String discount, String paymentPrice, String badge) {
        run(date, order);

        assertThat(output())
                .contains(
                        printDate,
                        "<주문 메뉴>",
                        "<할인 전 총주문 금액>",
                        totalPrice,
                        "<증정 메뉴>",
                        gift,
                        "<혜택 내역>",
                        "<총혜택 금액>",
                        discount,
                        "<할인 후 예상 결제 금액>",
                        paymentPrice,
                        "<12월 이벤트 배지>",
                        badge
                );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
