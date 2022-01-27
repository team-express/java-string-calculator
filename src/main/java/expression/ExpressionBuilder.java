package expression;

import checker.ValidStringExpressionChecker;

public class ExpressionBuilder {
	public static Expression makeExpression(String stringExpression) {
		Expression expression = null;

		String[] splitStringExpression = stringExpression.trim().split(" ");

		if(ValidStringExpressionChecker.check(splitStringExpression)){//ValidStringExpressionChecker 수정요망
			Object[] splitExpression = getSplitExpression(splitStringExpression);
			expression = new Expression(splitExpression);
		}

		return expression;
	}

	private static Object[] getSplitExpression(String[] splitStringExpression){
		Object[] splitExpression = splitStringExpression;

		for(int i=0;i<splitExpression.length;i+=2){
			splitExpression[i] = Integer.parseInt(splitStringExpression[i]);
		}

		return splitExpression;
	}
}
