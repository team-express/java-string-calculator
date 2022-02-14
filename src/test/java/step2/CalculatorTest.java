package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

// BDD 테스트 코드 작성 패턴
// Describe : 테스트 대상을 명사로 작성
// Context : ~인 경우, ~ 할 때, 만약 ~ 한다면과 같이 상황 또는 조건을 기술한다
// It : 위에서 명사로 작성한 테스트 대상의 행동을 ~이다, ~한다, ~를 갖는다 등으로 작성한다
@DisplayName("Calculator 클래스 동작 시나리오 테스트")
class CalculatorTest {

    @Nested
    @DisplayName("Describe: Calculator 생성자는")
    class Describe_constructor {

        // subject를 이용해 테스트 대상이 되는 메서드를 분리한다.
        // Calculator 생성자는 숫자와 연산자 모음을 받아, 상태로 가지고 있는 인스턴스를 만든다.
        private Calculator subject(List<Integer> numbers, List<Operator> operators) {
            return new Calculator(numbers, operators);
        }

        @Nested
        @DisplayName("Context: 최소 두 개의 숫자와 하나의 연산자가 넘어올 경우")
        class Context_two_number_and_one_operator {
            @Test
            @DisplayName("It: 계산기 객체를 반환한다.")
            void it_returns_a_equation() {
                assertNotNull(subject(Arrays.asList(1, 2), Arrays.asList(Operator.SUM)));
                assertThat(subject(Arrays.asList(1, 2), Arrays.asList(Operator.SUM))).isInstanceOf(Calculator.class);
            }
        }

        @Nested
        @DisplayName("Context: 한 개의 숫자와 한 개의 연산자만 넘어올 경우")
        class Context_one_number {
            @Test
            @DisplayName("It: 예외가 발생한다")
            void it_throws_exception() {
                assertThrows(IllegalArgumentException.class, () -> {
                    subject(Collections.singletonList(1), Collections.singletonList(Operator.SUM));
                });
            }
        }

        @Nested
        @DisplayName("Context: 연산자가 넘어오지 않을 경우")
        class Context_empty_operator {
            @Test
            @DisplayName("It: 예외가 발생한다")
            void it_throws_exception() {
                assertThrows(IllegalArgumentException.class, () -> {
                    subject(Arrays.asList(1, 2), Collections.emptyList());
                });
            }
        }

        @Nested
        @DisplayName("Context: 숫자 모음과 연산자 모음의 갯수 차이가 1이 아닐 경우")
        class Context_wrong_format {
            @Test
            @DisplayName("It: 예외가 발생한다")
            void it_throws_exception() {
                assertThrows(IllegalArgumentException.class, () -> {
                    subject(Arrays.asList(1, 2, 3), Collections.singletonList(Operator.SUM));
                });
            }
        }
    }

    @Nested
    @DisplayName("Describe: calculate 메소드는")
    class Describe_calculate {

        // subject를 이용해 테스트 대상이 되는 메서드를 분리한다.
        // Calculator 인스턴스의 calculate()를 실행한다.
        private int subject(List<Integer> numbers, List<Operator> operators) {
            Calculator calculator = new Calculator(numbers, operators);
            return calculator.calculate();
        }

        @Nested
        @DisplayName("Context: 정상적인 숫자 List와 연산자 List가 필드에 있을 경우")
        class Context_with_numbers_and_operators {

            @Test
            @DisplayName("It: calculator를 이용해 전체 계산 결과를 반환한다")
            void it_returns_a_result() {
                int calculateResult = subject(Arrays.asList(1, 2, 3), Arrays.asList(Operator.SUM, Operator.DIVISION));
                assertThat(calculateResult).isEqualTo(1);
            }
        }
    }
}


