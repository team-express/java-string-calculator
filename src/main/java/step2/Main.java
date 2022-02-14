package step2;

public class Main {

    // 프로그램 실행
    public static void main(String[] args) {
        CalculatorDisplay calculatorDisplay = new CalculatorDisplay(new StringCalculatePreparator());
        calculatorDisplay.displayConsole();
    }
}

