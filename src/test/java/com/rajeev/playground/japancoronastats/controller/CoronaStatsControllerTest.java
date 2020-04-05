package com.rajeev.playground.japancoronastats.controller;

import com.rajeev.playground.japancoronastats.contants.ApplicationConstants;
import com.rajeev.playground.japancoronastats.dto.CoronaStatsResponseDTO;
import java.util.Properties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.PropertyPlaceholderHelper;
import org.springframework.web.util.UriComponentsBuilder;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CoronaStatsControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void whenCoronaStatsExist_thenGetStats() {
        PropertyPlaceholderHelper propertyPlaceholderHelper = new PropertyPlaceholderHelper("{", "}");
        Properties properties = new Properties();
        properties.setProperty("prefecture", "saitama");
        String path = propertyPlaceholderHelper.replacePlaceholders(ApplicationConstants.CORONA_STATS, properties);
        RequestEntity<Void> requestEntity = RequestEntity
                .get(UriComponentsBuilder.fromPath(path).build().toUri())
                .accept(MediaType.APPLICATION_JSON)
                .build();

        ResponseEntity<CoronaStatsResponseDTO> responseEntity = testRestTemplate.exchange(requestEntity, CoronaStatsResponseDTO.class);
        assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
        Assertions.assertNotNull(responseEntity.getBody().getTested());
        Assertions.assertNotNull(responseEntity.getBody().getActive());
        Assertions.assertNotNull(responseEntity.getBody().getDeaths());
        Assertions.assertNotNull(responseEntity.getBody().getCritical());
    }

    @Test
    public void whenCoronaStatsDoesNotExist_thenGetStats() {
        PropertyPlaceholderHelper propertyPlaceholderHelper = new PropertyPlaceholderHelper("{", "}");
        Properties properties = new Properties();
        properties.setProperty("prefecture", "aichi");
        String path = propertyPlaceholderHelper.replacePlaceholders(ApplicationConstants.CORONA_STATS, properties);
        RequestEntity<Void> requestEntity = RequestEntity
                .get(UriComponentsBuilder.fromPath(path).build().toUri())
                .accept(MediaType.APPLICATION_JSON)
                .build();

        ResponseEntity<CoronaStatsResponseDTO> responseEntity = testRestTemplate.exchange(requestEntity, CoronaStatsResponseDTO.class);
        assertThat(responseEntity.getStatusCode(), is(HttpStatus.BAD_REQUEST));
    }

}
