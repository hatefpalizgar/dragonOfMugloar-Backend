package com.bigbank.hatef.dragonsofmugloar.controller;

import com.bigbank.hatef.dragonsofmugloar.model.message.Message;
import com.bigbank.hatef.dragonsofmugloar.model.message.TaskResult;
import com.bigbank.hatef.dragonsofmugloar.service.MessageService;
import com.bigbank.hatef.dragonsofmugloar.utils.MessageDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Component
@Slf4j
public class MessageController {
    
    @Autowired
    private MessageService messageService;
    
    private static double evaluate(Message t) {
        return t.getDifficulty() != 0 ? (double) t.expiresIn() + t.getDifficulty() : t.expiresIn();
    }
    
    public List<Message> getAllMessages(String gameId) {
        return messageService.getMessages(gameId);
    }
    
    public Message pickBestTask(List<Message> messageBoard) {
        return messageBoard.stream()
                           .map(t -> t.encrypted() == 1 ? MessageDecoder.decode(t) : t)
                           .filter(t -> t.encrypted() == 1 || t.encrypted() == 0)
                           .filter(t -> !t.message().contains("Steal"))
                           .sorted(Comparator.comparingDouble(MessageController::evaluate))
                           .collect(Collectors.toList()).get(0);
    }
    
    public TaskResult solve(String gameId, String adId) {
        return messageService.solveMessage(gameId, adId);
    }
}
