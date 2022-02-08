package expression;

public class ExpressionCalculator {
	private static final int FIRST_INDEX = 0;
	private static final int NEXT = 1;
	private static final int CARRY = 2;

	private ExpressionCalculator() {
	}

	private static int calculateOneWithOperator(int num1, int num2, String operator) {
		return CalculateType.of(operator).calculate(num1, num2);
	}

	public static int calculate(Expression expression) {

		Object[] splitExpression = expression.getExpression();

		int result = (Integer)splitExpression[FIRST_INDEX];

		for (int i = FIRST_INDEX + NEXT; i < splitExpression.length; i += CARRY) {
			int nextNumber = (Integer)splitExpression[i + NEXT];
			String operator = (String)splitExpression[i];

			result = calculateOneWithOperator(result, nextNumber, operator);
		}

		return result;
	}
}
