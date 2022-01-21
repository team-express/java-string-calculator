package checker;

import java.util.Arrays;

public class ValidStringExpressionChecker {

	private static final int FIRST_INDEX = 0;

	private ValidStringExpressionChecker() {
	}

	private static boolean isNumber(char c) {
		return c >= '0' && c <= '9';
	}

	private static boolean isAllNumber(String s) {
		int i;
		int length = s.length();

		for (i = FIRST_INDEX; i < length && isNumber(s.charAt(i)); i++)
			;

		return i == length;
	}

	private static boolean isOneOperator(String s) {

		if (s.length() != 1)
			return false;

		char c = s.charAt(FIRST_INDEX);

		return c == '+' || c == '*' || c == '-' || c == '/';
	}

	public static boolean check(String s) {

		String[] splitExpression = s.trim().split(" ");

		int numberIndex;
		for (numberIndex = 0;
			 numberIndex < splitExpression.length && isAllNumber(splitExpression[numberIndex]); numberIndex += 2)
			;

		int operatorIndex;
		for (operatorIndex = 1; operatorIndex < splitExpression.length && isOneOperator(
			splitExpression[operatorIndex]); operatorIndex += 2)
			;

		return numberIndex == splitExpression.length + 1 && operatorIndex == splitExpression.length;
	}
}
