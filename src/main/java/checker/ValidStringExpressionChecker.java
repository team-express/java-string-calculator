package checker;

public class ValidStringExpressionChecker {
	private static boolean isNumber(char c) {
		return c >= '0' && c <= '9';
	}

	public static boolean isAllNumber(String s) {
		int i;

		for (i = 0; i < s.length() && isNumber(s.charAt(i)); i++)
			;

		return i == s.length();
	}
}
