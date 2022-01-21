package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTests {

	@Test
	@DisplayName("두 수와 연산자를 입력 받아 결과를 반환한다.")
	void testCalculateOneWithOperator(){
		StringCalculator.calculateOneWithOperator(1,1,"+");
	}
}
