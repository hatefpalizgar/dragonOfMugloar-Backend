package com.bigbank.hatef.dragonsofmugloar.service;

import com.bigbank.hatef.dragonsofmugloar.model.game.Game;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@RestClientTest({ShopService.class, GameService.class})
public class ShopServiceTest {
    
    @Autowired
    private GameService gameService;
    
    @Autowired
    private ShopService shopService;
    
    private Game game;
    
    @Before
    public void init() {
        game = gameService.start();
    }
    
    @Test
    public void givenRequestShopItems_thenReturnValidItems() {
        assertThat(shopService.getAllItems(game.gameId()).get(0).id()).isNotEmpty();
        assertThat(shopService.getAllItems(game.gameId()).get(0).cost()).isNotZero();
        assertThat(shopService.getAllItems(game.gameId()).get(0).name()).isNotEmpty();
    }
    
    @Test
    public void givenPurchaseItem_thenIncreaseTurnByOne() {
        String itemId = shopService.getAllItems(game.gameId()).get(0).id();
        int previousTurn = game.turn();
        assertThat(shopService.purchase(game.gameId(), itemId).turn()).isEqualTo(previousTurn + 1);
    }
}