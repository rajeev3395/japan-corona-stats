package com.rajeev.playground.japancoronastats.controller;

import com.rajeev.playground.japancoronastats.dto.CoronaStatsResponseDTO;
import com.rajeev.playground.japancoronastats.service.CoronaStatisticsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static com.rajeev.playground.japancoronastats.contants.ApplicationConstants.CORONA_STATS;

@Slf4j
@RequiredArgsConstructor
@RestController
public class CoronaStatsController {

    private final CoronaStatisticsService coronaStatisticsService;

    @GetMapping(value = CORONA_STATS, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getCoronaStatistics(@PathVariable(value = "prefecture") String prefectureName) {
        log.debug("Received the stats request for prefecture : {}", prefectureName);
        CoronaStatsResponseDTO stats = coronaStatisticsService.getCoronaStatsByPrefectureName(prefectureName);
        return ResponseEntity.ok(stats);
    }
}
