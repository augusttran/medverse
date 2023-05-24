package druginfo.autocorrectsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@EnableEurekaClient
@SpringBootApplication
public class AutocorrectsearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutocorrectsearchApplication.class, args);
	}

}
