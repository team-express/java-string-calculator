package calstringgame;

import expression.Expression;
import expression.ExpressionBuilder;
import expression.ExpressionCalculator;

public class GameManager {
	private static final String TO_STRING = "";

	private String stringExpression;
	private String result;

	public GameManager() {
		this.stringExpression = null;
		this.result = null;
	}

	public void init(String stringExpression) {
		this.stringExpression = stringExpression;
	}

	public void play() {

		if (stringExpression == null)
			return;

		Expression expression = ExpressionBuilder.makeExpression(stringExpression);

		if (!(expression == null))
			this.result = ExpressionCalculator.calculate(expression) + TO_STRING;
	}

	public String getResult() {
		return this.result;
	}
}
