package com.rajeev.playground.japancoronastats.service;

import com.rajeev.playground.japancoronastats.dao.CoronaDetailsEntity;
import com.rajeev.playground.japancoronastats.dao.CoronaStatsRepository;
import com.rajeev.playground.japancoronastats.dto.CoronaStatsResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class CoronaStatsService {

    private final CoronaStatsRepository coronaStatsRepository;

    public CoronaStatsResponseDTO getCoronaStats(String prefectureName) {
        try {
            CoronaDetailsEntity detailsEntity = coronaStatsRepository.getByPrefectureName(prefectureName);
            return CoronaStatsResponseDTO.builder().build();
        } catch (Exception ex) {
            log.error("Exception is thrown during the query by prefecture name : {}", prefectureName, ex);
            throw ex;
        }
    }
}
