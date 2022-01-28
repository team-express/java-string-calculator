package study;

public class SimpleCalculator {

	private final Equation equation;

	private static final String NO_DIVIDE_BY_ZERO = "0으로 나눌 수 없습니다.";

	public SimpleCalculator(Equation equation) {
		this.equation = equation;
	}

	public int cal(String symbol, Integer num1, Integer num2) {
		if (symbol.equals(SymbolStatus.PLUS.toString())) {
			return num1 + num2;
		}

		if (symbol.equals(SymbolStatus.MINUS.toString())) {
			return num1 - num2;
		}

		if (symbol.equals(SymbolStatus.MULTIPLY.toString())) {
			return num1 * num2;
		}

		if (symbol.equals(SymbolStatus.DIVISION.toString())) {
			checkDivideByZero(num2);
			return num1 / num2;
		}

		throw new IllegalStateException("잘못 입력하셨습니다..");
	}

	private void checkDivideByZero(Integer num) {
		if (num == 0) {
			throw new ArithmeticException(NO_DIVIDE_BY_ZERO);
		}
	}

	public int calEquation() {
		int cal = cal(
			equation.getSymbolsList().get(0),
			equation.getNumbers().get(0),
			equation.getNumbers().get(1));

		for (int i = 1; i < equation.getSymbolsList().size(); i++) {
			cal = cal(equation.getSymbolsList().get(i), cal, equation.getNumbers().get(i + 1));
		}

		return cal;
	}
}
