package de.wellnerbou.jodatimeparse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static com.google.common.truth.Truth.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JavaTimeParseControllerSpringTest {

	@Autowired
	private JavaTimeParseController controller;

	@Test
	public void contexLoads() {
		assertThat(controller).isNotNull();
	}

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void parse() {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/parse?datestr=May 13 at 23:28&format=MMM dd 'at' HH:mm",
				String.class)).contains("\"SecondOfDay\":84480");
	}
}
