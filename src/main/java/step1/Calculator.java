package step1;

import java.util.List;

public class Calculator {

    private CalculatorResource calculatorResource;

    public Calculator(String stringCalculatorSentence) {
        this.calculatorResource = new CalculatorResource(stringCalculatorSentence);
    }

    public int calculate() {

        List<Integer> numberList = calculatorResource.getNumberArray();
        List<String> operatorList = calculatorResource.getOperatorArray();

        int operatorListIndex = 0;
        int result = 0;

        for (int i = 1; i < numberList.size(); i++) {

            result = calcualteInit(numberList, result, i);

            result = getResult(numberList, operatorList, operatorListIndex, result, i);
            operatorListIndex++;
        }
        return result;
    }

    private int calcualteInit(List<Integer> numberList, int result, int i) {
        if (i == 1) {
            result = (numberList.get(i - 1));
        }
        return result;
    }

    private int getResult(List<Integer> numberList, List<String> operatorList, int operatorListIndex, int result, int i) {
        if (operatorList.get(operatorListIndex).equals("+")) {
            result = result + (numberList.get(i));
        } else if (operatorList.get(operatorListIndex).equals("-")) {
            result = result - (numberList.get(i));
        } else if (operatorList.get(operatorListIndex).equals("*")) {
            result = result * (numberList.get(i));
        } else if (operatorList.get(operatorListIndex).equals("/")) {
            result = result / (numberList.get(i));
        }
        return result;
    }
}
