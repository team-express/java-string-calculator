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
		int length = splitStringExpression.length;

		Object[] splitExpression = new Object[length];

		for(int i=0;i<length;i+=2){
			splitExpression[i] = (Integer.parseInt(splitStringExpression[i]));
		}

		for(int i=1;i<length;i+=2){
			splitExpression[i] = splitStringExpression[i];
		}

		return splitExpression;
	}
}
