package com.bigbank.hatef.dragonsofmugloar.service;

import com.bigbank.hatef.dragonsofmugloar.model.message.Message;
import com.bigbank.hatef.dragonsofmugloar.model.message.TaskResult;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
@Slf4j
public class MessageService {
    Logger logger = LoggerFactory.getLogger(MessageService.class);
    
    @Autowired
    RestTemplate restTemplate;
    
    @Value("${game.endpoint.messages}")
    private String urlAllMessages;
    
    @Value("${game.endpoint.message.solve}")
    private String urlSolveMessage;
    
    public List<Message> getMessages(String gameId) {
        urlAllMessages = String.format(urlAllMessages, gameId);
        try {
            Message[] messages = restTemplate.getForObject(urlAllMessages, Message[].class);
            return Arrays.asList(messages != null ? messages : new Message[0]);
        } catch (HttpClientErrorException e) {
            logger.error(e.getMessage());
            return new ArrayList<>();
        }
    }
    
    public TaskResult solveMessage(String gameId, String adId) {
        urlSolveMessage = String.format("https://dragonsofmugloar.com/api/v2/%s/solve/%s", gameId, adId);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        try {
            TaskResult taskResult = restTemplate.postForObject(urlSolveMessage, headers, TaskResult.class);
            logger.info("RESULT -> " + (taskResult != null ? taskResult.message() : "no task available"));
            return taskResult;
        } catch (HttpClientErrorException e) {
            logger.error(e.getMessage());
            return new TaskResult();
        }
    }
}
