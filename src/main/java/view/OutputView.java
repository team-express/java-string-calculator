package view;

public class OutputView {
	private static final String ERROR_MESSAGE = "입력 값이 없거나, 잘못된 형식의 수식입니다.";

	public void print(String result) {

		if (result == null) {
			result = ERROR_MESSAGE;
		}

		System.out.println(result);
	}
}
