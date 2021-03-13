package dev.byronzaharako.playground;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PlaygroundApplicationTests {

	@Test
	void contextLoads() {
		assertThat(System.currentTimeMillis() > 0).isTrue();
	}

}
