package expression;

public class ExpressionBuilder {

	private static final int FIRST_INDEX = 0;
	private static final int NEXT = 1;
	private static final int CARRY = 2;

	private ExpressionBuilder() {

	}

	public static Expression makeExpression(String stringExpression) {
		Expression expression = null;

		String[] splitStringExpression = stringExpression.trim().split(" ");

		if (ValidStringExpressionChecker.check(splitStringExpression)) {
			Object[] splitExpression = getSplitExpression(splitStringExpression);
			expression = new Expression(splitExpression);
		}

		return expression;
	}

	private static Object[] getSplitExpression(String[] splitStringExpression) {
		int length = splitStringExpression.length;

		Object[] splitExpression = new Object[length];

		splitExpression[FIRST_INDEX] = Integer.parseInt(splitStringExpression[FIRST_INDEX]);

		for (int index = FIRST_INDEX + NEXT; index < length; index += CARRY) {
			splitExpression[index] = splitStringExpression[index];
			splitExpression[index + NEXT] = Integer.parseInt(splitStringExpression[index + NEXT]);
		}

		return splitExpression;
	}
}
