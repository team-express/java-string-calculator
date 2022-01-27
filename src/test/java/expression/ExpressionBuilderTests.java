package expression;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ExpressionBuilderTests {
	@ParameterizedTest
	@CsvSource(value = {" 2 + 3 / 5:true", "2 + 3  / 5:false", " 2 + 3 /5:false"," 2 + 33 / 5:true"},delimiter = ':')
	@DisplayName("문자열을 받아 내부적으로 수식이 될 수 있는 문자열인지 검사한 후 수식객체를 반환")
	void testMakeExpression(String input, boolean output){
		Expression expression = ExpressionBuilder.makeExpression(input);
		assertThat(expression != null).isEqualTo(output);
		System.out.println(expression);
	}
}
