package casepractice.calculator;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public enum Operator {
    SUM("+", Integer::sum),
    SUBTRACTION("-", (a, b) -> a - b),
    MULTIPLICATION("*", (a, b) -> a * b),
    DIVISION("/", (a, b) -> a / b);

    private final String symbol;
    private final IntBinaryOperator calculation;

    Operator(String symbol, IntBinaryOperator calculation) {
        this.symbol = symbol;
        this.calculation = calculation;
    }

    static Operator from(String symbol) {
        return Arrays.stream(Operator.values())
                .filter(operator -> symbol.equals(operator.symbol))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public int calculate(int a, int b) {
        return calculation.applyAsInt(a, b);
    }
}
