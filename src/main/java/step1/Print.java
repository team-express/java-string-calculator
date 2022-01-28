package step1;

public class Print {

    private int calculateResult;

    public Print(int calculateResult) {
        this.calculateResult = calculateResult;
    }

    public void printResult() {
        System.out.println("calculateResult = " + calculateResult);
    }
}
