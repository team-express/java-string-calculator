package calculator;

public class StringCalculator {
	private static final int FIRST_NUMBER = 0;
	private static final int NEXT_NUMBER = 2;

	private static int calculateOneWithOperator(int num1, int num2, String operator) {

		if (operator.equals("+"))
			num1 += num2;

		if (operator.equals("-"))
			num1 -= num2;

		if (operator.equals("*"))
			num1 *= num2;

		if (operator.equals("/"))
			num1 /= num2;

		return num1;
	}

	public static int calculate(String[] splitExpression) {
		int result = Integer.parseInt(splitExpression[FIRST_NUMBER]);

		for (int i = NEXT_NUMBER; i < splitExpression.length; i += NEXT_NUMBER) {
			int nextNumber = Integer.parseInt(splitExpression[i]);
			String operator = splitExpression[i - 1];

			result = calculateOneWithOperator(result, nextNumber, operator);
		}

		return result;
	}
}
