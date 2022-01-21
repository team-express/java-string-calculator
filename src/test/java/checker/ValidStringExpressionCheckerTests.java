package checker;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

public class ValidStringExpressionCheckerTests {

	@Test
	@DisplayName("주어진 문자열이 숫자인가")
	void testIsAllNumber() {
		assertThat(ValidStringExpressionChecker.isAllNumber("333")).isTrue;
		assertThat(ValidStringExpressionChecker.isAllNumber("3 ")).isFalse;
		assertThat(ValidStringExpressionChecker.isAllNumber(" 3")).isFalse;
		assertThat(ValidStringExpressionChecker.isAllNumber("33a")).isFalse;
	}

	@Test
	@DisplayName("주어진 한 문자가 숫자인가")
	void testIsNumber(){
		assertThat(ValidStringExpressionChecker.isNumber('3')).isTrue();
		assertThat(ValidStringExpressionChecker.isNumber('+')).isFalse();
		assertThat(ValidStringExpressionChecker.isNumber(' ')).isFalse();
		assertThat(ValidStringExpressionChecker.isNumber('a')).isFalse();
	}
}
