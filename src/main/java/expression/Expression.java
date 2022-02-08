package expression;

import java.util.Arrays;
import java.util.List;

public class Expression {
	private List<Integer> numbers;
	private List<String> operators;

	Expression(List<Integer> numbers, List<String> operators) {
		this.numbers = numbers;
		this.operators = operators;
	}

	@Override
	public String toString() {
		return "Expression{" +
			"numbers=" + numbers +
			", operators=" + operators +
			'}';
	}
}
