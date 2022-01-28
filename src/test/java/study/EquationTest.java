package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class EquationTest {

	@ParameterizedTest
	@ValueSource(strings = {"/", "+"})
	@DisplayName("연산 기호만 반환")
	void returnSymbolList(String symbol) {
		//given
		String input = "3 / 4 + 5";
		Equation equation = new Equation(input);

		//when
		List<String> symbols = equation.getSymbolsList();

		//then
		assertThat(symbols.contains(symbol)).isTrue();
	}

	@ParameterizedTest
	@ValueSource(ints = {3, 4})
	@DisplayName("숫자들만 반환")
	void returnIntList(int num) {
		//given
		String input = "3 + 4";
		Equation equation = new Equation(input);

		//when
		List<Integer> ints = equation.getNumbers();

		//then
		assertThat(ints.contains(num)).isTrue();
	}
}
