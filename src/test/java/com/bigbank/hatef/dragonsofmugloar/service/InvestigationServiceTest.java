package com.bigbank.hatef.dragonsofmugloar.service;

import com.bigbank.hatef.dragonsofmugloar.model.game.Game;
import com.bigbank.hatef.dragonsofmugloar.model.game.Reputation;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@RestClientTest({GameService.class, InvestigationService.class})
public class InvestigationServiceTest {
    
    @Autowired
    private InvestigationService investigationService;
    
    @Autowired
    private GameService gameService;
    
    private Game game;
    
    @Before
    public void init() {
        game = gameService.start();
    }
    
    @Test
    public void givenGameStarted_thenDefaultReputationIsGenerated() {
        Reputation reputation = investigationService.getReputation(game.gameId());
        assertThat(reputation.people()).isEqualTo(0);
        assertThat(reputation.state()).isEqualTo(0);
        assertThat(reputation.underworld()).isEqualTo(0);
    }
}