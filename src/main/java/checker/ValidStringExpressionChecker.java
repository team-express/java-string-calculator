package checker;

public class ValidStringExpressionChecker {
	private static boolean isNumber(char c) {
		return c >= '0' && c <= '9';
	}

	private static boolean isAllNumber(String s) {
		int i;
		int length = s.length();

		for (i = 0; i < length && isNumber(s.charAt(i)); i++)
			;

		return i == length;
	}
}
