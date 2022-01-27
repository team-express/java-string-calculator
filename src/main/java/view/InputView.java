package view;

import java.util.Scanner;

public class InputView {
	private final Scanner scanner;

	public InputView(Scanner scanner) {
		this.scanner = scanner;
	}

	public int read() {
		return scanner.nextInt();
	}
}
