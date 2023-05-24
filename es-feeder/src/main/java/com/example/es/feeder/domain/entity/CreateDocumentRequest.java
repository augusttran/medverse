package com.example.es.feeder.domain.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateDocumentRequest<D> {
    @Setter(AccessLevel.PRIVATE)
    String documentId;
    @Setter(AccessLevel.PRIVATE)
    String index;
    D data;

    public Class<D> getType() {
        return (Class<D>) data.getClass();
    }
}
