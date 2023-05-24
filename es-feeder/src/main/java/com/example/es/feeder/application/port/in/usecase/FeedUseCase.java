package com.example.es.feeder.application.port.in.usecase;

import com.example.es.feeder.domain.entity.CreateDocumentRequest;

public interface FeedUseCase {
    void feed(CreateDocumentRequest<?> request);
}
