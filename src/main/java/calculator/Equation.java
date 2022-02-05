package calculator;

import java.util.Collections;
import java.util.List;

public class Equation {

    private static final int NUMBERS_MIN_SIZE = 2;
    private static final int OPERATORS_MIN_SIZE = 1;
    private static final int NUMBERS_AND_OPERATORS_INTERVAL = 1;

    private final List<Integer> numbers;
    private final List<Operator> operators;

    public Equation(List<Integer> numbers, List<Operator> operators) {
        validateMinSize(numbers, operators);
        validateFormat(numbers, operators);
        this.numbers = Collections.unmodifiableList(numbers);
        this.operators = Collections.unmodifiableList(operators);
    }

    private void validateMinSize(List<Integer> numbers, List<Operator> operators) {
        if (numbers.size() < NUMBERS_MIN_SIZE) {
            throw new IllegalArgumentException(String.format("방정식의 숫자의 수는 %d개 이상이어야 합니다.", NUMBERS_MIN_SIZE));
        }

        if (operators.size() < OPERATORS_MIN_SIZE) {
            throw new IllegalArgumentException(String.format("방정식의 연산자의 수는 %d개 이상이어야 합니다.", OPERATORS_MIN_SIZE));
        }
    }

    private void validateFormat(List<Integer> numbers, List<Operator> operators) {
        int interval = numbers.size() - operators.size();
        if (interval != NUMBERS_AND_OPERATORS_INTERVAL) {
            throw new IllegalArgumentException("방정식의 올바른 형식이 아닙니다.");
        }
    }

    public int calculate() {
        int result = numbers.get(0);
        for (int i = 0; i < operators.size(); i++) {
            Operator operator = operators.get(i);
            Integer number = numbers.get(i + 1);
            result = operator.calculate(result, number);
        }
        return result;
    }
}
