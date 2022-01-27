package CalStringGame;

import expression.Expression;
import expression.ExpressionBuilder;
import expression.ExpressionCalculator;

public class GameManager {
	private final String ERROR_MESSAGE = "입력을 하지 않았거나, 잘못된 형식의 수식입니다.";

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

		this.result = ExpressionCalculator.calculate(expression) + "";
	}

	public String getResult() {
		if (result == null)
			return ERROR_MESSAGE;

		return this.result;
	}
}
