package dev.byronzaharako.playground;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

@SpringBootTest
class PlaygroundApplicationTests {

	@DynamicPropertySource
	public static void properties(DynamicPropertyRegistry registry) {
	}

	@Test
	void contextLoads() {
		assertThat(System.currentTimeMillis() > 0).isTrue();
	}

}
