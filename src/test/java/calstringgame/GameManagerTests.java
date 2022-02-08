package calstringgame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameManagerTests {
	private GameManager manager;

	@BeforeEach
	@DisplayName("")
	void setUp() {
		manager = new GameManager();
		manager.init(" 2 + 3 * 4 / 2 ");
	}

	@Test
	@DisplayName("")
	void test() {
		manager.play();
		assertThat(manager.getResult()).isEqualTo("10");
	}

}
