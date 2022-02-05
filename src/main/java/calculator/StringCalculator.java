package calculator;

public class StringCalculator {

    private final EquationFactory equationFactory;

    public StringCalculator(EquationFactory equationFactory) {
        this.equationFactory = equationFactory;
    }

    public int calculate(String input) {
        Equation equation = equationFactory.create(input);
        return equation.calculate();
    }
}
