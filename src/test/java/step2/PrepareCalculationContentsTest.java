package step2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("PrepareCalculationContentsTest 클래스 동작 시나리오 테스트")
class PrepareCalculationContentsTest {

    @Nested // 테스트 클래스의 하위 구조로 선언한다
    @DisplayName("Describe: create 메소드는")
    class Describe_constructor {

        // subject를 이용해 테스트 대상이 되는 메서드를 분리한다.
        // create()는 문자열 식을 숫자와 연산자로 가공하고, 전체 계산을 담당하는 Calculator 객체를 반환한다.
        private Calculator subject(String stringExpression) {
            return new PrepareCalculationContents().create(stringExpression);
        }

        @Nested // 테스트 클래스의 하위 구조로 선언한다
        @DisplayName("Context: 규격에 맞는 방정식 문자열이 주어진다면")
        class Context_right_input {
            @Test
            @DisplayName("It: 계산기 객체를 반환한다")
            void it_returns_a_equation() {
                assertNotNull(subject("1 + 2 / 3 + 5"));
                Assertions.assertThat(subject("1 + 2 / 3 + 5")).isInstanceOf(Calculator.class);
            }
        }

        @Nested
        @DisplayName("Context: 규격에 맞지 않는 방정식 문자열이 주어진다면")
        class Context_wrong_input {
            @Test
            @DisplayName("It: 예외가 발생한다")
            void it_throws_exception() {
                assertThrows(IllegalArgumentException.class, () -> {
                    subject(" 1 ! 2 - 3");
                });
            }
        }
    }
}
