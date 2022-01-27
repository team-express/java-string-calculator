package expression;

import java.util.Arrays;

public class Expression {
	private Object[] expression;

	Expression(Object[] expression) {//package
		this.expression = expression;
	}

	@Override
	public String toString() {
		return "Expression{" +
			"expression=" + Arrays.toString(expression) +
			'}';
	}
}
