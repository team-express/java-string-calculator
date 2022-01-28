package study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Equation {

	private final String equation;

	private static final String INVALID_CALCULATION_FORMAT = "잘못된 계산식입니다.";
	private static final String DELIMITER = " ";

	public Equation(String equation) {
		this.equation = equation;
		checkEquation();
	}

	public void checkEquation() {
		String[] split = equation.split(DELIMITER);

		for (int i = 0; i < split.length; ) {
			checkDoubleNumber(split, i);
			i += 2;
		}

		for (int i = 1; i < split.length; ) {
			checkDoubleSymbol(split, i);
			i += 2;
		}

	}

	public List<Integer> getNumbers() {
		List<Integer> numList = new ArrayList<>();
		String[] inputArr = equation.split(DELIMITER);
		Arrays.stream(inputArr).filter(this::isParesInt).forEach(s -> addNumList(numList, s));
		return numList;
	}

	public List<String> getSymbolsList() {
		List<String> symbolList = new ArrayList<>();
		String[] inputArr = equation.split(DELIMITER);
		Arrays.stream(inputArr).filter(s -> !isParesInt(s))
			.forEach(s -> addSymbolList(symbolList, s));
		return symbolList;
	}

	private boolean isParesInt(String input) {
		return input.chars().allMatch(Character::isDigit);
	}

	private void addNumList(List<Integer> numList, String input) {
		numList.add(Integer.parseInt(input));
	}

	private void addSymbolList(List<String> symbolList, String input) {
		checkSymbol(input);
		symbolList.add(input);
	}

	private void checkSymbol(String input) {
		if (!SymbolStatus.checkSymbol(input)) {
			throw new IllegalStateException(INVALID_CALCULATION_FORMAT);
		}
	}

	private void checkDoubleNumber(String[] split, int i) {
		boolean parseInt = isParesInt(split[i]);
		if (!parseInt) {
			throw new IllegalStateException(INVALID_CALCULATION_FORMAT);
		}
	}

	private void checkDoubleSymbol(String[] split, int i) {
		boolean parse = isParesInt(split[i]);
		if (parse) {
			throw new IllegalStateException(INVALID_CALCULATION_FORMAT);
		}
	}

}
