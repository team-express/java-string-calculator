package study;

import java.util.Arrays;

public enum SymbolStatus {
	PLUS("+"), MINUS("-"), MULTIPLY("*"), DIVISION("/");

	private String value;

	SymbolStatus(String value) {
		this.value = value;
	}

	public String toString() {
		return this.value;
	}

	public static boolean checkSymbol(String inputArr) {
		return Arrays.stream(values()).anyMatch(value -> value.toString().equals(inputArr));
	}
}
