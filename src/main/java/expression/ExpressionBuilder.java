package expression;

import java.util.ArrayList;
import java.util.List;

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
			List<Integer> numbers = getNumbers(splitStringExpression);
			List<String> operators = getOperators(splitStringExpression);

			expression = new Expression(numbers, operators);
		}

		return expression;
	}

	private static List<Integer> getNumbers(String[] splitStringExpression) {
		List<Integer> numbers = new ArrayList<>();

		for (int index = FIRST_INDEX; index < splitStringExpression.length; index += CARRY) {
			numbers.add(Integer.parseInt(splitStringExpression[index]));
		}

		return numbers;
	}

	private static List<String> getOperators(String[] splitStringExpression) {
		List<String> operators = new ArrayList<>();

		for (int index = FIRST_INDEX + NEXT; index < splitStringExpression.length; index += CARRY) {
			operators.add(splitStringExpression[index]);
		}

		return operators;
	}
}
