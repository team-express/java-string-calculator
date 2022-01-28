package study;

public class ResultView {

	public void initStart() {
		System.out.println("계산식을 입력하세요.");
	}

	public void viewResult(SimpleCalculator simpleCalculator) {
		int result = simpleCalculator.calEquation();
		System.out.println("계산 결과 = " + result);
	}
}
