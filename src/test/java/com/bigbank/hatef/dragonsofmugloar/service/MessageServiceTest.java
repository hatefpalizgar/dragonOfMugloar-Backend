package com.bigbank.hatef.dragonsofmugloar.service;

import com.bigbank.hatef.dragonsofmugloar.model.game.Game;
import com.bigbank.hatef.dragonsofmugloar.model.message.Message;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@RestClientTest({MessageService.class, GameService.class})
public class MessageServiceTest {
    
    @Autowired
    private MessageService messageService;
    
    @Autowired
    private GameService gameService;
    
    private Game game;
    
    @Before
    public void init() {
        game = gameService.start();
    }
    
    @Test
    public void givenRequestAllMessages_thenReturnedListIsNotEmpty() {
        assertThat(messageService.getMessages(game.gameId())).hasSizeGreaterThan(1);
    }
    
    @Test
    public void givenRequestAllMessages_thenAdIdIsNotNull() {
        assertThat(messageService.getMessages(game.gameId()).get(0).adId()).isNotEmpty();
    }
    
    @Test
    public void givenSolvedMessage_thenTurnIsIncreasedByOne() {
        List<Message> messages = messageService.getMessages(game.gameId());
        assertThat(messageService.solveMessage(game.gameId(), messages.get(0).adId()).turn()).isEqualTo(game.turn());
    }
}