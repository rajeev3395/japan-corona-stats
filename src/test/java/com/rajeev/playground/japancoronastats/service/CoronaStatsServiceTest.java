package com.rajeev.playground.japancoronastats.service;

import com.rajeev.playground.japancoronastats.dao.CoronaDetailsEntity;
import com.rajeev.playground.japancoronastats.dao.CoronaStatsRepository;
import com.rajeev.playground.japancoronastats.dto.CoronaStatsResponseDTO;
import com.rajeev.playground.japancoronastats.exception.CoronaDetailsNotExistException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {CoronaStatsService.class, CoronaStatsRepository.class})
public class CoronaStatsServiceTest {

    @Autowired
    private CoronaStatsService coronaStatsService;

    @MockBean
    private CoronaStatsRepository mockRepo;

    @Test
    public void whenCoronaStatsExist_thenGetStats() {
        mockCoronaStatsRepoResponse();
        CoronaStatsResponseDTO coronaStats = coronaStatsService.getCoronaStats("saitama");
        Assertions.assertNotNull(coronaStats.getTested());
        Assertions.assertNotNull(coronaStats.getActive());
        Assertions.assertNotNull(coronaStats.getDeaths());
        Assertions.assertNotNull(coronaStats.getCritical());
    }

    @Test
    public void whenCoronaStatsDoesNotExist_GetStats_thenCoronaDetailsNotExistException() {
        Assertions.assertThrows(CoronaDetailsNotExistException.class,
                () -> coronaStatsService.getCoronaStats("aichi"));
    }

    private void mockCoronaStatsRepoResponse() {
        when(mockRepo.getByPrefectureName(anyString()))
                .thenReturn(new CoronaDetailsEntity("saitama",
                        100L,
                        20L,
                        3L,
                        17L,
                        3L,
                        0L,
                        Timestamp.valueOf(LocalDateTime.now()),
                        Timestamp.valueOf(LocalDateTime.now()))
                );
    }

}
