package calstringgame;

import view.InputView;
import view.OutputView;

public class Main {
	public static void main(String[] args) {
		InputView inputView = new InputView();
		OutputView outputView = new OutputView();
		GameManager manager = new GameManager();

		start(inputView, outputView, manager);
	}

	private static void start(InputView inputView, OutputView outputView, GameManager manager) {
		outputView.print(manager.play(inputView.read()));
	}
}
