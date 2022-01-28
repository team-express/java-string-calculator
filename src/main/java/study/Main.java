package study;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ResultView resultView = new ResultView();

		resultView.initStart();
		Scanner scanner = new Scanner(System.in);
		InputView inputView = new InputView(scanner);

		Equation equation = new Equation(inputView.readEquation());
		SimpleCalculator simpleCalculator = new SimpleCalculator(equation);

		resultView.viewResult(simpleCalculator);

	}
}
