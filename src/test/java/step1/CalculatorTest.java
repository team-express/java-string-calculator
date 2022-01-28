package step1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    @DisplayName("숫자 리스트와 연산자 리스트로 계산을 실행하는 테스트")
    void calculateTest () throws Exception{

    // given
        String sentence = "1 + 2 + 3 - 6 * 100 + 5 / 5";

    // when
        Calculator calculator = new Calculator(sentence);
        int result = calculator.calculate();

    // then
        Assertions.assertThat(result).isEqualTo(1);
    }
}
