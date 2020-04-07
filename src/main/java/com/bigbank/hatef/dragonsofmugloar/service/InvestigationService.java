package com.bigbank.hatef.dragonsofmugloar.service;

import com.bigbank.hatef.dragonsofmugloar.model.game.Reputation;
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
public class InvestigationService {
    Logger logger = LoggerFactory.getLogger(InvestigationService.class);
    @Autowired
    RestTemplate restTemplate;
    
    @Value("${game.endpoint.investigate}")
    private String urlGetReputation;
    
    public Reputation getReputation(String gameId) {
        urlGetReputation = String.format(urlGetReputation, gameId);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        try {
            return restTemplate.postForObject(urlGetReputation, headers, Reputation.class);
        } catch (HttpClientErrorException e) {
            logger.error(e.getMessage());
            return null;
        }
    }
}
