package checker;

import java.util.Arrays;

public class ValidStringExpressionChecker {

	private static final int FIRST_INDEX = 0;
	private static final int FIRST_INDEX_FOR_OPERATOR = 1;
	private static final int CARRY = 2;

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

	private static boolean isEvenNumber(int number) {
		return number % 2 == 0;
	}

	public static boolean check(String[] splitStringExpression) {

		//나중에 시간을 들여서 사용자가 이상하게 입력했을때를 대비해보자!

		int length = splitStringExpression.length;

		if (isEvenNumber(length))
			return false;

		int index = FIRST_INDEX_FOR_OPERATOR;
		for (; index < length && isAllNumber(splitStringExpression[index + 1]) && isOneOperator(
			splitStringExpression[index]); index += CARRY)
			;

		return index == length;
	}
}
