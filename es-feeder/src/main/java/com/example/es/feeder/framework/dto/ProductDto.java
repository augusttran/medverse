package com.example.es.feeder.framework.dto;

import lombok.*;

@Builder
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductDto {
    String id;
    String name;
    String labeller;
}
