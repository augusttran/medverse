package com.example.es.feeder.application.discovery;

import com.example.es.feeder.domain.factory.EntityFactory;

public interface FactoryDiscovery {
    <R, E> EntityFactory<R, E> explore(Class<? extends R> resourceType, Class<? extends E> entityType);
}
