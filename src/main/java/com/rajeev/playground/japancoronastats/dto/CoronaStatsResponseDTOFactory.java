package com.rajeev.playground.japancoronastats.dto;

import com.rajeev.playground.japancoronastats.dao.CoronaDetailsEntity;

public class CoronaStatsResponseDTOFactory {

    /**
     *
     * @param entity CoronaDetailsEntity
     * @return CoronaStatsResponseDTO
     */
    public static CoronaStatsResponseDTO create(CoronaDetailsEntity entity) {
        return CoronaStatsResponseDTO.builder()
                .tested(entity.getTested())
                .confirmed(entity.getConfirmed())
                .active(entity.getActive())
                .critical(entity.getCritical())
                .deaths(entity.getDeaths())
                .recovered(entity.getRecovered())
                .build();
    }
}
