package com.example.es.feeder.framework.config.bean;

import com.example.es.feeder.application.port.in.FeedInputPort;
import com.example.es.feeder.application.port.out.FeedOutputPort;
import com.example.es.feeder.domain.entity.CreateDocumentRequest;
import com.example.es.feeder.domain.factory.EntityFactory;
import com.example.es.feeder.domain.entity.DrugDocument;
import com.example.es.feeder.domain.entity.ProductDocument;
import com.example.es.feeder.framework.dto.DrugDto;
import com.example.es.feeder.framework.dto.ProductDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class BeanConfig {
    @Bean
    FeedInputPort simpleInputPort(FeedOutputPort feedOutputPort) {
        return new FeedInputPort(feedOutputPort);
    }

    @Bean
    EntityFactory<DrugDto, CreateDocumentRequest<DrugDocument>> drugDocumentRequestFactory() {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return resource -> CreateDocumentRequest.<DrugDocument>builder()
            .documentId(resource.getId())
            .index("drugs")
            .data(mapper.convertValue(resource, DrugDocument.class))
            .build();
    }

    @Bean
    EntityFactory<ProductDto, CreateDocumentRequest<ProductDocument>> productDocumentRequestFactory() {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return resource -> CreateDocumentRequest.<ProductDocument>builder()
            .documentId(resource.getId())
            .index("products")
            .data(mapper.convertValue(resource, ProductDocument.class))
            .build();
    }
}
