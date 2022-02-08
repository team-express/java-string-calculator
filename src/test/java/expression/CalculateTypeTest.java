package expression;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class CalculateTypeTest {
	@Test
	void test() {
		CalculateType c = CalculateType.of("+");
		System.out.println(c.calculate(1, 2));
	}
}
