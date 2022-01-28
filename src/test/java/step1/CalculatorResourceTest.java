package step1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorResourceTest {

    @Test
    @DisplayName("빈칸으로 구분된 문자열을 받아 숫자만 반환하는 테스트")
    void creatNumberListTest() throws Exception {

        // given
        String sentence = "51 + 2 + 100";
        CalculatorResource calculatorResource = new CalculatorResource(sentence);

        // when
        List<Integer> numberList = calculatorResource.getNumberArray();

        // then
        List<Integer> expectList = new ArrayList<Integer>(Arrays.asList(51, 2, 100));
        Assertions.assertThat(numberList).isEqualTo(expectList);

    }

    @Test
    @DisplayName("빈칸으로 구분된 문자열을 받아 연산자만 반환하는 테스트")
    void creatOperatorList() {

        // given
        String sentence = "1 + 2 - 3 * 100 / 5";
        CalculatorResource calculatorResource = new CalculatorResource(sentence);

        // when
        List<String> operatorList = calculatorResource.getOperatorArray();

        // then
        List<String> expectList = new ArrayList<String>(Arrays.asList("+", "-" , "*" , "/"));
        Assertions.assertThat(operatorList).isEqualTo(expectList);
    }
}
