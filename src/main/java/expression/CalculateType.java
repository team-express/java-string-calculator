package expression;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;

public enum CalculateType {
	ADDITION("+", (num1, num2) -> num1 + num2),
	SUBTRACTION("-", (num1, num2) -> num1 - num2),
	MULTIPLICATION("*", (num1, num2) -> num1 * num2),
	DIVISION("/", (num1, num2) -> num1 / num2);

	private String operator;
	private BiFunction<Integer, Integer, Integer> expression;

	CalculateType(String operator, BiFunction<Integer, Integer, Integer> expression) {
		this.operator = operator;
		this.expression = expression;
	}

	public int calculate(int num1, int num2) {
		return expression.apply(num1, num2);
	}

	static CalculateType of(String operator) {
		return Arrays.stream(values())
			.filter(v -> v.operator.equals(operator))
			.findFirst()
			.get();
	}
}
