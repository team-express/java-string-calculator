package step2;

import java.util.function.BiFunction;

import static java.util.Arrays.stream;

public enum Operator {

    SUM("+", (a, b) -> a + b),
    SUBTRACTION("-", (a, b) -> a - b),
    MULTIPLICATION("*", (a, b) -> a * b),
    DIVISION("/", (a, b) -> a / b);

    // 4개의 enum 객체는 operatorSymbol에 따라 서로 다른 연산 로직을 수행한다.
    private final String operatorSymbol;
    private final BiFunction<Integer, Integer, Integer> biFunction; // 두 개의 Integer 타입을 받아 Integer 타입을 반환

    // 4개의 enum 객체 생성자
    Operator(String operatorSymbol, BiFunction<Integer, Integer, Integer> biFunction) {
        this.operatorSymbol = operatorSymbol;
        this.biFunction = biFunction;
    }

    // enum 객체가 가지고 있는 BiFunction 인터페이스 구현 로직에 따라 계산 결과를 반환한다.
    public int calculate(int a, int b) {
        return this.biFunction.apply(a,b);
    }

    // 문자 형태의 연산자를 operatorSymbol로 가지고 있는 enum 객체를 찾아 반환한다.
    static Operator matchOperator(String symbol) {
        return stream(Operator.values()) // Operator의 모든 값을 순환한다.
                .filter(operator -> symbol.equals(operator.operatorSymbol))// 파라미터로 넘어온 symbol과 enum 객체의 operatorSymbol이 일치하면 통과
                .findFirst() // enum 객체를 찾으면 반환한다.
                .orElseThrow(IllegalArgumentException::new); // 일치하는 객체가 없다면 예외 발생
    }

}
