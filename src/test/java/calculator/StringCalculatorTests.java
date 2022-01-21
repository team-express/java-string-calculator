package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTests {
	@Test
	@DisplayName("split으로 인하여 나누어진 String[]타입의 수식을 계산하여 반환한다.")
	void testCalculate() {
		String[] arr = "2 + 3 * 4 / 2".split(" ");

		int result = StringCalculator.calculate(arr);

		assertThat(result).isEqualTo(10);
	}
}
