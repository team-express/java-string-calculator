package calstringgame;

import expression.Expression;
import expression.ExpressionBuilder;
import expression.ExpressionCalculator;
import view.InputView;
import view.OutputView;

public class Main {
	public static void main(String[] args) {
		InputView inputView = new InputView();
		OutputView outputView = new OutputView();

		start(inputView, outputView);
	}

	private static void start(InputView inputView, OutputView outputView) {
		String stringExpression = inputView.read();

		String result = play(stringExpression);

		outputView.print(result);
	}

	private static String play(String stringExpression) {
		String result = null;

		Expression expression = ExpressionBuilder.makeExpression(stringExpression);

		if (expression != null) {
			result = ExpressionCalculator.calculate(expression) + "";
		}

		return result;
	}
}
