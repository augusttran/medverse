package com.example.es.feeder.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DrugDocument {
    String name;
    String indication;
    String mechanism;
    String pharmacodynamics;
}
