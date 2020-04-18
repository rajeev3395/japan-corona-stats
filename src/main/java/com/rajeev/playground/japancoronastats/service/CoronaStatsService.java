package com.rajeev.playground.japancoronastats.service;

import com.rajeev.playground.japancoronastats.dao.CoronaDetailsEntity;
import com.rajeev.playground.japancoronastats.dao.CoronaStatsRepository;
import com.rajeev.playground.japancoronastats.dto.CoronaStatsResponseDTO;
import com.rajeev.playground.japancoronastats.dto.CoronaStatsResponseDTOFactory;
import com.rajeev.playground.japancoronastats.exception.CoronaDetailsNotExistException;
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
            if (null == detailsEntity) {
                throw new CoronaDetailsNotExistException("Details do not exist for prefecture : " + prefectureName);
            }
            return CoronaStatsResponseDTOFactory.create(detailsEntity);
        } catch (Exception ex) {
            log.error("Exception is thrown during the query by prefecture name : {}", prefectureName, ex);
            throw ex;
        }
    }
}
