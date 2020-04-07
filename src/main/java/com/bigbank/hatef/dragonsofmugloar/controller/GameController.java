package com.bigbank.hatef.dragonsofmugloar.controller;

import com.bigbank.hatef.dragonsofmugloar.model.game.Game;
import com.bigbank.hatef.dragonsofmugloar.model.message.Message;
import com.bigbank.hatef.dragonsofmugloar.model.message.TaskResult;
import com.bigbank.hatef.dragonsofmugloar.model.shop.PurchaseResult;
import com.bigbank.hatef.dragonsofmugloar.service.GameService;
import com.bigbank.hatef.dragonsofmugloar.service.InvestigationService;
import com.bigbank.hatef.dragonsofmugloar.utils.MessageDecoder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Data
@Slf4j
public class GameController {
    
    @Autowired
    private GameService gameService;
    
    @Autowired
    private InvestigationService investigationService;
    
    @Autowired
    private MessageController messageController;
    
    @Autowired
    private ShopController shopController;
    
    @Autowired
    private MessageDecoder decoder;
    
    @Value("${game.shop.item.healing}")
    private String hpot;
    
    @Value("${game.play.text.end}")
    private String gameOver;
    
    private Game game;
    private Message pickedMessage;
    private TaskResult taskResult;
    private String gameId;
    
    public void play() {
        initialize();
        start();
    }
    
    private void initialize() {
        game = gameService.start();
        gameId = game.gameId();
    }
    
    private void start() {
        while (game.lives() > 0) {
            solve();
            checkHealth();
            updateLevel();
        }
    }
    
    private void solve() {
        List<Message> messageBoard = messageController.getAllMessages(gameId);
        pickedMessage = messageController.pickBestTask(messageBoard);
        taskResult = messageController.solve(gameId, pickedMessage.adId());
        updateGame(taskResult);
    }
    
    public void updateGame(TaskResult result) {
        game.gold(result.gold());
        game.lives(result.lives());
        game.score(result.score());
        game.turn(result.turn());
        game.highScore(result.highScore());
        log.info("Lives:{}, Gold:{}, Level:{}, Score:{}, Turn:{}", game.lives(), game.gold(), game.level(), game.score(), game.turn());
    }
    
    public void updateGame(PurchaseResult result) {
        game.gold(result.gold());
        game.lives(result.lives());
        game.level(result.level());
        game.turn(result.turn());
    }
    
    private void updateLevel() {
        if (pickedMessage.getDifficulty() > 1 && game.gold() >= 100) {
            PurchaseResult randomItem = shopController.purchaseRandom(game.gameId());
            updateGame(randomItem);
        }
    }
    
    private void checkHealth() {
        if (game.lives() == 1) {
            PurchaseResult purchaseResult = shopController.purchase(game.gameId(), hpot);
            updateGame(purchaseResult);
        } else if (game.lives() == 0) {
            log.info(gameOver);
            System.exit(0);
        }
    }
}
