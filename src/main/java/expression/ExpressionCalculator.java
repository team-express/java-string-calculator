package expression;

import java.util.List;

public class ExpressionCalculator {
	private static final int FIRST_INDEX = 0;
	private static final int NEXT = 1;

	private ExpressionCalculator() {
	}

	private static int calculateOneWithOperator(int num1, int num2, String operator) {
		return CalculateType.of(operator).calculate(num1, num2);
	}

	public static int calculate(Expression expression) {

		List<Integer> numbers = expression.getNumbers();
		List<String> operators = expression.getOperators();

		int result = numbers.get(FIRST_INDEX);

		for (int index = FIRST_INDEX; index < operators.size(); index++) {
			int nextNumber = numbers.get(index + NEXT);
			String operator = operators.get(index);

			result = calculateOneWithOperator(result, nextNumber, operator);
		}

		return result;
	}
}
