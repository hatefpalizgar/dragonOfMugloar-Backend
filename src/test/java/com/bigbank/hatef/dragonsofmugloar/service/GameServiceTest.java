package com.bigbank.hatef.dragonsofmugloar.service;

import com.bigbank.hatef.dragonsofmugloar.model.game.Game;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@RestClientTest(GameService.class)
public class GameServiceTest {
    
    @Autowired
    private GameService gameService;
    
    @Test
    public void givenGameStarted_shouldReturnValidGameInstance() {
        Game actualGame = gameService.start();
        assertThat(actualGame).hasFieldOrProperty("lives");
        assertThat(actualGame.lives()).isEqualTo(3);
    }
}