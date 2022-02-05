package calculator;

@FunctionalInterface
public interface EquationFactory {
    Equation create(String equation);
}
