package calstringgame;

import java.util.Scanner;

import view.InputView;
import view.OutputView;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		InputView inputView = new InputView(scanner);
		OutputView outputView = new OutputView();
		GameManager manager = new GameManager();

		start(inputView, outputView, manager);
	}

	private static void start(InputView inputView, OutputView outputView, GameManager manager) {
		manager.init(inputView.read());
		manager.play();
		outputView.print(manager.getResult());
	}
}
