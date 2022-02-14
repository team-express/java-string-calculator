package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

// BDD 테스트 코드 작성 패턴
// Describe : 테스트 대상을 명사로 작성
// Context : ~인 경우, ~ 할 때, 만약 ~ 한다면과 같이 상황 또는 조건을 기술한다
// It : 위에서 명사로 작성한 테스트 대상의 행동을 ~이다, ~한다, ~를 갖는다 등으로 작성한다
@DisplayName("Operator 클래스 동작 시나리오 테스트")
class OperatorTest {

    @Nested // 테스트 클래스의 하위 구조로 선언한다
    @DisplayName("Describe: matchOperator 메소드는")
    class Describe_matchOperator {

        // subject를 이용해 테스트 대상이 되는 메서드를 분리한다.
        // 문자 타입의 operatorSymbol을 받아, 일치하는 enum 객체를 반환한다.
        Operator subject(String symbol) {
            return Operator.matchOperator(symbol);
        }

        @Nested
        @DisplayName("Context: + 문자열이 파라미터로 넘어올 경우")
        class Context_with_add_symbol {

            @Test
            @DisplayName("It: SUM을 반환한다")
            void it_returns_a_sum() {
                assertThat(subject("+")).isEqualTo(Operator.SUM);
            }
        }

        @Nested
        @DisplayName("Context: - 문자열이 파라미터로 넘어올 경우")
        class Context_with_subtraction_symbol {
            @Test
            @DisplayName("It: SUBTRACTION을 반환한다")
            void it_returns_a_subtraction() {
                assertThat(subject("-")).isEqualTo(Operator.SUBTRACTION);
            }
        }

        @Nested
        @DisplayName("Context: * 문자열이 파라미터로 넘어올 경우")
        class Context_with_multiplication_symbol {
            @Test
            @DisplayName("It: MULTIPLICATION을 반환한다")
            void it_returns_a_multiplication() {
                assertThat(subject("*")).isEqualTo(Operator.MULTIPLICATION);
            }
        }

        @Nested
        @DisplayName("Context: / 문자열이 파라미터로 넘어올 경우")
        class Context_with_division_symbol {
            @Test
            @DisplayName("It: DIVISION을 반환한다")
            void it_returns_a_division() {
                assertThat(subject("/")).isEqualTo(Operator.DIVISION);
            }
        }

        @Nested
        @DisplayName("Context: 파라미터로 넘어온 문자와 일치하는 operatorSymbol이 없을 경우")
        class Context_with_other_symbol {
            @ParameterizedTest // 메서드 파라미터에 여러개의 인수를 전달하는 방식으로 테스트 진행
            @ValueSource(strings = {",", ":"}) // 메서드 실행 당 파라미터로 인수(argument)를 하나씩 전달
            @DisplayName("It: 예외가 발생한다.")
            void it_throws_exception(String symbol) {
                assertThrows(IllegalArgumentException.class, () -> {
                    subject(symbol);
                });
            }
        }
    }

    @Nested
    @DisplayName("Describe: calculate 메소드는")
    class Describe_calculate {
        private int a, b;

        // 임의의 테스트 값 세팅
        @BeforeEach
        void prepareNumbers() {
            a = 10;
            b = 5;
        }

        // subject를 이용해 테스트 대상이 되는 메서드를 분리한다.
        // Enum 객체와 두 수를 받아 계산 결과를 반환한다.
        int subject(Operator operator, int a, int b) {
            return operator.calculate(a, b);
        }

        @Nested
        @DisplayName("Context: 덧셈을 담당하는 SUM이 두 정수 a와 b를 받을 경우")
        class Context_with_add_and_numbers {
            @Test
            @DisplayName("It: a+b의 결과를 반환한다")
            void it_returns_a_sum() {
                assertThat(subject(Operator.SUM, a, b)).isEqualTo(15);
            }
        }

        @Nested
        @DisplayName("Context: 뺄셈을 담당하는 SUBTRACTION이 두 정수 a와 b를 받을 경우")
        class Context_with_subtract_and_numbers {
            @Test
            @DisplayName("It: a-b의 결과를 반환한다")
            void it_returns_a_subtraction() {
                assertThat(subject(Operator.SUBTRACTION, a, b)).isEqualTo(5);
            }
        }

        @Nested
        @DisplayName("Context: 곱셈을 담당하는 SUBTRACTION이 두 정수 a와 b를 받을 경우")
        class Context_with_multiply_and_numbers {
            @Test
            @DisplayName("It: a*b의 결과를 반환한다")
            void it_returns_a_multiplication() {
                assertThat(subject(Operator.MULTIPLICATION, a, b)).isEqualTo(50);
            }
        }

        @Nested
        @DisplayName("Context: 나눗셈을 담당하는 DIVISION이 두 정수 a와 b를 받을 경우")
        class Context_with_divide_and_numbers {
            @Test
            @DisplayName("It: a/b의 결과를 반환하고, 나머지 있을 경우 생략한다.")
            void it_returns_a_division() {
                assertThat(subject(Operator.DIVISION, a, b)).isEqualTo(2);
            }
        }

        @Nested
        @DisplayName("Context: 나눗셈을 담당하는 DIVISION이 받은 수에 0이 있을 경우")
        class Context_with_divide_and_numbers_with_zero {
            @Test
            @DisplayName("It: ArithmeticException 예외가 발생한다")
            void it_throws_exception() {
                assertThrows(ArithmeticException.class, () -> {
                    subject(Operator.DIVISION, 0, 0);
                });
            }
        }
    }
}

