package calstringgame;

import expression.Expression;
import expression.ExpressionBuilder;
import expression.ExpressionCalculator;

public class GameManager {
	private static final String TO_STRING = "";

	public String play(String stringExpression) {

		String result = null;

		if (stringExpression == null) {
			return result;
		}

		Expression expression = ExpressionBuilder.makeExpression(stringExpression);

		if (expression != null) {
			result = ExpressionCalculator.calculate(expression) + TO_STRING;
		}

		return result;
	}
}
