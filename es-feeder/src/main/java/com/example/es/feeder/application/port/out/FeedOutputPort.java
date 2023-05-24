package com.example.es.feeder.application.port.out;

import com.example.es.feeder.domain.entity.CreateDocumentRequest;

import java.util.stream.Stream;

public interface FeedOutputPort {
    <T> void feed(CreateDocumentRequest<T> request);
    <T> void feedMany(Stream<CreateDocumentRequest<? extends T>> requests);
}
