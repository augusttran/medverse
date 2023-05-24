package com.example.es.feeder.framework.dto;

import lombok.*;

@Builder
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DrugDto {
    String id;
    String name;
    String indication;
    String mechanism;
    String pharmacodynamics;
}
