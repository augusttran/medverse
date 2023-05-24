package com.example.es.feeder.framework.config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EsConfig {
    @Value("${app.elasticsearch.host}")
    String host;
    @Value("${app.elasticsearch.port}")
    int port;

    @Bean
    RestClient httpClient() {
        return RestClient.builder(
            new HttpHost(host, port)
        ).build();
    }

    @Bean
    ElasticsearchTransport elasticsearchTransport() {
        return new RestClientTransport(
            httpClient(),
            new JacksonJsonpMapper()
        );
    }

    @Bean
    ElasticsearchClient esClient() {
        return new ElasticsearchClient(elasticsearchTransport());
    }
}
