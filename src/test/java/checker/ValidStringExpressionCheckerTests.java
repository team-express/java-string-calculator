package checker;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

public class ValidStringExpressionCheckerTests {

	//차후 0이먼저 나오는 숫자들도 처리할 것

	@ParameterizedTest
	@CsvSource(value = {" 2 + 3 / 5:true", "2 + 3  / 5 :false", " 2 + 3 /5:false", " 2 + 33 / 5:true"}, delimiter = ':')
	@DisplayName("주어진 문자열배열이 수식이 될 수 있는지 검사한다. (홀수자리가 숫자, 짝수자리가 (하나의) 연산자)")
	void testCheck(String input, boolean output) {
		assertThat(ValidStringExpressionChecker.check(input.trim().split(" "))).isEqualTo(output);
	}
}
