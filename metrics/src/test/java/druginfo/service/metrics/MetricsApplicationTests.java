package druginfo.service.metrics;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@WebFluxTest
@AutoConfigureWebTestClient
class MetricsApplicationTests {

	@Autowired
	WebTestClient webTestClient;

	@Test
	void contextLoads() {
	}

}
