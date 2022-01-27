package expression;

import java.util.Arrays;

public class ValidStringExpressionChecker {

	private static final int FIRST_INDEX = 0;
	private static final int NEXT = 1;//숫자의 다음은 항상 연산자, 연산자의 다음도 항상 숫자
	private static final int CARRY = 2;//올림수(연산자~다음연산자, 숫자~다음숫자)

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

	static boolean check(String[] splitStringExpression) {//package

		int length = splitStringExpression.length;

		if (isEvenNumber(length))
			return false;

		if (!isAllNumber(splitStringExpression[FIRST_INDEX]))
			return false;

		int index = FIRST_INDEX + NEXT;
		for (; index < length && isAllNumber(splitStringExpression[index + NEXT]) && isOneOperator(
			splitStringExpression[index]); index += CARRY)
			;

		return index == length;
	}
}
