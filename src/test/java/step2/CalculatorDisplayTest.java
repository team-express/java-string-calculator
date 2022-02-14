package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("CalculatorDisplay 클래스 동작 시나리오 테스트")
class CalculatorDisplayTest {

    @Nested
    @DisplayName("Describe: calculate 메소드는")
    class Describe_calculate {

        // subject를 이용해 테스트 대상이 되는 메서드를 분리한다.
        // 계산기 준비 장치를 의존 관계로 주입받은 CalculatorDisplay 객체를 반환한다.
        private int subject(String stringExpression) {
             CalculatorDisplay calculatorDisplay = new CalculatorDisplay(new StringCalculatePreparator());
             return calculatorDisplay.calculateForTest(stringExpression);
        }

        @Nested
        @DisplayName("Context: 문자열 방정식이 주어진다면")
        class Context_with_input {
            @Test
            @DisplayName("It: 계산 결과를 반환한다")
            void it_returns_a_result() {
                assertThat(subject("2 + 3 * 4 / 2")).isEqualTo(10);
            }
        }

    }
}
