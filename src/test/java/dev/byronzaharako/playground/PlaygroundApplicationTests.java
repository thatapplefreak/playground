package dev.byronzaharako.playground;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
class PlaygroundApplicationTests {

	@Test
	void contextLoads() {
		assertThat(System.currentTimeMillis() > 0).isTrue();
	}

	private static MockMvc mockMvc;

    @BeforeAll
    public static void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(new Controller()).build();
    }

    @Test
    void testSayHelloWorld() throws Exception {
        mockMvc.perform(get("/hello")
           .accept("application/json;charset=UTF-8")
		)
			.andDo(print())
           .andExpect(status().isOk())
           .andExpect(content().contentType("application/json;charset=UTF-8"))
		   .andExpect(content().string("hello world!"));

    }


    @Test
    void testRootEndpoint() throws Exception {
        mockMvc.perform(get("/")
           .accept("application/json;charset=UTF-8")
		)
			.andDo(print())
           .andExpect(status().isOk())
           .andExpect(content().contentType("application/json;charset=UTF-8"))
		   .andExpect(content().string("root"));

    }

}
