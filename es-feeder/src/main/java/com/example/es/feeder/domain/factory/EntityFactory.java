package com.example.es.feeder.domain.factory;

public interface EntityFactory<R, E> {
    E from(R resource);
}
