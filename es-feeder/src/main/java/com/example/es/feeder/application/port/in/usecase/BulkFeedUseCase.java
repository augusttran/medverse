package com.example.es.feeder.application.port.in.usecase;

import com.example.es.feeder.domain.entity.CreateDocumentRequest;

import java.util.stream.Stream;

public interface BulkFeedUseCase {
    void feed(CreateDocumentRequest<?>...requests);
}
