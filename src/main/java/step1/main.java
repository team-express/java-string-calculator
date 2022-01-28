package step1;

public class main {

    public static void main(String[] args) {
        String stringCalculatorSentence = "1 * 2 - 3 + 4 * 5";
        Calculator calculator = new Calculator(stringCalculatorSentence);
        Print print = new Print(calculator.calculate());
        print.printResult();
    }
}
