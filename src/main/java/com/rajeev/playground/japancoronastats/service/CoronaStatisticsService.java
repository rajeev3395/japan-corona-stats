package com.rajeev.playground.japancoronastats.service;

import com.rajeev.playground.japancoronastats.dto.CoronaStatsResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class CoronaStatisticsService {

    public CoronaStatsResponseDTO getCoronaStatsByPrefectureName(String prefectureName) {
        return CoronaStatsResponseDTO.builder().build();
    }
}
