package com.bigbank.hatef.dragonsofmugloar.service;

import com.bigbank.hatef.dragonsofmugloar.model.game.Game;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


@Service
public class GameService {
    Logger logger = LoggerFactory.getLogger(GameService.class);
    
    @Autowired
    RestTemplate restTemplate;
    
    @Value(value = "${game.endpoint.start}")
    private String urlGameStart;
    
    public Game start() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        try {
            logger.info("****** game started ******");
            return restTemplate.postForObject(urlGameStart, headers, Game.class);
        } catch (HttpClientErrorException e) {
            logger.error(e.getMessage());
            return null;
        }
    }
}
