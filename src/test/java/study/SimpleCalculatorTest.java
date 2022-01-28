package study;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class SimpleCalculatorTest {

	@Test
	void plusTest() {
		//given
		String input = "10 + 5";
		Equation equation = new Equation(input);
		SimpleCalculator calculator = new SimpleCalculator(equation);

		//when
		int result = calculator.cal(
			equation.getSymbolsList().get(0),
			equation.getNumbers().get(0),
			equation.getNumbers().get(1));

		//then
		assertThat(result).isEqualTo(15);
	}

	@Test
	void minusTest() {
		//given
		String input = "10 - 5";
		Equation equation = new Equation(input);
		SimpleCalculator calculator = new SimpleCalculator(equation);

		//when
		int result = calculator.cal(
			equation.getSymbolsList().get(0),
			equation.getNumbers().get(0),
			equation.getNumbers().get(1));

		//then
		assertThat(result).isEqualTo(5);
	}

	@Test
	void multiplyTest() {
		//given
		String input = "10 * 5";
		Equation equation = new Equation(input);
		SimpleCalculator calculator = new SimpleCalculator(equation);
		//when
		int result = calculator.cal(
			equation.getSymbolsList().get(0),
			equation.getNumbers().get(0),
			equation.getNumbers().get(1));

		//then
		assertThat(result).isEqualTo(50);
	}

	@Test
	void divisionTest() {
		//given
		String input = "10 / 5";
		Equation equation = new Equation(input);
		SimpleCalculator calculator = new SimpleCalculator(equation);
		//when
		int result = calculator.cal(
			equation.getSymbolsList().get(0),
			equation.getNumbers().get(0),
			equation.getNumbers().get(1));

		//then
		assertThat(result).isEqualTo(2);
	}

}
