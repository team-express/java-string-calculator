package step2;

import java.util.Scanner;

public class CalculatorDisplay {

    private final CalculatePreparator calculatePreparator;


    // 계산기 재료를 준비해주는 인터페이스를 의존 관계로 받는다.
    // 구현체를 변경하는 방식으로 계산기 기능을 다르게 사용할 수 있다.
    public CalculatorDisplay(CalculatePreparator calculatePreparator) {
        this.calculatePreparator = calculatePreparator;

    }

    // 양식에 맞는 문자열 수식을 넣으면 전체 계산 결과를 반환한다
    // test
    private int calculate(String userInputExpression) {
        Calculator calculator = calculatePreparator.create(userInputExpression); // 계산 준비 객체에서 계산기 객체를 만든다.
        return calculator.calculate(); // 계산기 객체가 계산 결과를 반환한다.
    }

    public int calculateForTest(String userInputExpression) {
        Calculator calculator = calculatePreparator.create(userInputExpression); // 계산 준비 객체에서 계산기 객체를 만든다.
        return calculator.calculate(); // 계산기 객체가 계산 결과를 반환한다.
    }

    public void displayConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("문자열 계산식을 입력하면 계산 결과를 반환합니다.");
        int calculateResult = calculate(scanner.nextLine());
        System.out.println("calculateResult = " + calculateResult);
    }
}
