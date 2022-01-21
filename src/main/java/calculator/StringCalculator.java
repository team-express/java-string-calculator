package calculator;

public class StringCalculator {
	private static int calculateOneWithOperator(int num1, int num2, String operator) {

		if (operator.equals("+"))
			num1 += num2;

		if (operator.equals("-"))
			num1 -= num2;

		if (operator.equals("*"))
			num1 *= num2;

		//0으로 나누는 것 나중에
		if (operator.equals("/"))
			num1 /= num2;

		return num1;
	}
}
