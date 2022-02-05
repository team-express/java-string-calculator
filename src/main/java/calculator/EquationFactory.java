package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EquationFactory {

    private static final String SEPARATOR = " ";
    private static final int INTERVAL = 2;

    public Equation create(String equation) {
        List<String> strings = Arrays.asList(equation.split(SEPARATOR));
        List<Integer> numbers = createNumbers(strings);
        List<Operator> operators = createOperators(strings);
        return new Equation(numbers, operators);
    }

    private List<Integer> createNumbers(List<String> strings) {
        List<String> evenPositions = new ArrayList<>();
        for (int i = 0; i < strings.size(); i = i + INTERVAL) {
            evenPositions.add(strings.get(i));
        }
        return evenPositions.stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    private List<Operator> createOperators(List<String> strings) {
        List<String> oddPositions = new ArrayList<>();
        for (int i = 1; i < strings.size(); i = i + INTERVAL) {
            oddPositions.add(strings.get(i));
        }
        return oddPositions.stream()
                .map(Operator::from)
                .collect(Collectors.toList());
    }
}
