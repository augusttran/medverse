package com.example.es.feeder.framework.adapter.out;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.BulkRequest;
import co.elastic.clients.elasticsearch.core.CreateRequest;
import co.elastic.clients.elasticsearch.core.UpdateRequest;
import co.elastic.clients.elasticsearch.core.bulk.BulkOperation;
import co.elastic.clients.elasticsearch.core.bulk.UpdateAction;
import co.elastic.clients.elasticsearch.core.bulk.UpdateOperation;
import co.elastic.clients.elasticsearch.indices.CreateIndexRequest;
import com.example.es.feeder.application.port.out.FeedOutputPort;
import com.example.es.feeder.domain.entity.CreateDocumentRequest;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Slf4j
@Component
public class ElasticsearchOutputAdapter implements FeedOutputPort, InitializingBean {
    private final ElasticsearchClient esClient;

    @Override
    @SneakyThrows
    public <T> void feed(CreateDocumentRequest<T> request) {
        log.info("feed start: id: {} payload: {}", request.getDocumentId(), request);
        var req = new UpdateRequest.Builder<T, T>()
            .id(request.getDocumentId())
            .index(request.getIndex())
            .doc(request.getData())
            .docAsUpsert(true)
            .build();

        esClient.update(req, request.getType());

        log.info("feed done: id {}", request.getDocumentId());
    }

    @Override
    @SneakyThrows
    public <T> void feedMany(Stream<CreateDocumentRequest<? extends T>> requests) {
        List<BulkOperation> operationList =
            requests.map(r -> new BulkOperation.Builder()
                .update(new UpdateOperation.Builder<T, T>()
                    .id(r.getDocumentId())
                    .index(r.getIndex())
                    .action(new UpdateAction.Builder<T, T>()
                        .upsert(r.getData())
                        .build())
                    .build())
                .build()).collect(Collectors.toList());
        esClient.bulk(new BulkRequest.Builder()
            .operations(operationList)
            .build());
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
