package druginfo.autocorrectsearch.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "druginfo.autocorrectsearch.repository")
@ComponentScan(basePackages = { "druginfo.autocorrectsearch" })
public class ESConfig extends AbstractElasticsearchConfiguration{

    @Bean
    public RestHighLevelClient elasticsearchClient() {

        final ClientConfiguration clientConfiguration =
                ClientConfiguration
                        .builder()
                        .connectedTo("localhost:9200")
                        .build();

        return RestClients
                .create(clientConfiguration)
                .rest();
    }

    @Value("${elasticsearch.url}")
    private String elasticsearchUrl;

}
