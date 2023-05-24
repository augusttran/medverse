package com.example.es.feeder.application.port.in;

import com.example.es.feeder.application.port.in.usecase.BulkFeedUseCase;
import com.example.es.feeder.application.port.out.FeedOutputPort;
import com.example.es.feeder.application.port.in.usecase.FeedUseCase;
import com.example.es.feeder.domain.entity.CreateDocumentRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.stream.Stream;

@RequiredArgsConstructor
@Slf4j
public class FeedInputPort implements FeedUseCase, BulkFeedUseCase {
    private final FeedOutputPort feedOutputPort;

    @Override
    public void feed(CreateDocumentRequest<?> request) {
        log.info("feed start: id: {} payload: {}", request.getDocumentId(), request);
        feedOutputPort.feed(request);
        log.info("feed done: id {}", request.getDocumentId());

    }

    @Override
    public void feed(CreateDocumentRequest<?> ...requests) {
        var stream = Stream.of(requests).peek(e -> log.info("preparing: id: {}", e.getDocumentId()));
        feedOutputPort.feedMany(stream);
    }
}
