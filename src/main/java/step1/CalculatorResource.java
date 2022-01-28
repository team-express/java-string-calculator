package step1;

import java.util.ArrayList;
import java.util.List;

public class CalculatorResource {

    private String sentence;
    private String[] sentenceArray;
    private List<Integer> numberArray;
    private List<String> operatorArray;

    public List<Integer> getNumberArray() {
        return numberArray;
    }

    public List<String> getOperatorArray() {
        return operatorArray;
    }

    public CalculatorResource(String sentence) {
        this.sentence = sentence;
        splitSentence();
        creatNumberList();
        creatOperatorList();
    }

    private void splitSentence() {
        this.sentenceArray = this.sentence.split(" ");
    }

    public void creatNumberList() {
        this.numberArray = new ArrayList<>();

        for (String s : sentenceArray) {
            char numberCheck = s.charAt(0);
            validateNumber(numberArray, s, numberCheck);
        }
        this.numberArray = numberArray;
    }

    private void validateNumber(List<Integer> numberArray, String s, char numberCheck) {
        if (numberCheck > 48 && numberCheck < 58) {
            this.numberArray.add(Integer.parseInt(s));
        }
    }

    public void creatOperatorList() {
        this.operatorArray = new ArrayList<>();

        for (String s : sentenceArray) {
            char operatorCheck = s.charAt(0);
            validateOperator(operatorArray, s, operatorCheck);
        }
    }

    private void validateOperator(List<String> operatorArray, String s, char operatorCheck) {
        if (operatorCheck < 48 || operatorCheck > 58) {
            this.operatorArray.add(s);
        }
    }


}
