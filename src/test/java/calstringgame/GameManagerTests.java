package calstringgame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameManagerTests {
	private GameManager manager;

	@BeforeEach
	void setUp() {
		manager = new GameManager();
	}

	@Test
	void test() {
		assertThat(manager.play(" 2 + 3 * 4 / 2 ")).isEqualTo("10");
	}

}
