package expression;

import checker.ValidStringExpressionChecker;

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

		for (int i = FIRST_INDEX; i < length; i += CARRY) {
			splitExpression[i] = Integer.parseInt(splitStringExpression[i]);
		}

		for (int i = FIRST_INDEX + NEXT; i < length; i += CARRY) {
			splitExpression[i] = splitStringExpression[i];
		}

		return splitExpression;
	}
}
