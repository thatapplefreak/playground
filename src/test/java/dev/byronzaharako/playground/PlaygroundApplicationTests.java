package dev.byronzaharako.playground;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

@SpringBootTest
class PlaygroundApplicationTests {

	protected static PostgreSQLContainer<?> dbContainer = new PostgreSQLContainer<>(DockerImageName.parse("postgres:latest"));

	@DynamicPropertySource
    public static void properties(DynamicPropertyRegistry registry) {
		dbContainer.start();
		registry.add("spring.datasource.url", () -> dbContainer.getJdbcUrl());
		registry.add("spring.datasource.username", () -> dbContainer.getUsername());
		registry.add("spring.datasource.password", () -> dbContainer.getPassword());
	}

	@Test
	void contextLoads() {
		assertThat(System.currentTimeMillis() > 0).isTrue();
	}

}
