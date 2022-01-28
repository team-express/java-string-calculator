package study;

import java.util.Scanner;

public class InputView {

	private Scanner scanner;

	public InputView(Scanner scanner) {
		this.scanner = scanner;
	}

	public String readEquation() {
		return scanner.nextLine();
	}
}
