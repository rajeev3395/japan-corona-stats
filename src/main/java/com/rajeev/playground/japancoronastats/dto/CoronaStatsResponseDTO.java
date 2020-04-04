package com.rajeev.playground.japancoronastats.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CoronaStatsResponseDTO {
    private final Long tested;
    private final Long confirmed;
    private final Long recovered;
    private final Long active;
    private final Long critical;
    private final Long deaths;
}
