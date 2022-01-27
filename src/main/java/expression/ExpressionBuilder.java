package expression;

import checker.ValidStringExpressionChecker;

public class ExpressionBuilder {
	public static Expression makeExpression(String stringExpression) {
		Expression expression = null;

		String[] splitStringExpression = stringExpression.trim().split(" ");

		if(ValidStringExpressionChecker.check(splitStringExpression)){
			Object[] splitExpression = method();//어떤 메서드
			expression = new Expression(splitExpression);
		}

		return expression;
	}
}
