package com.example.es.feeder.domain.entity;

import lombok.*;

@Builder
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductDocument {
    String name;
    String labeller;
}
