package com.bigbank.hatef.dragonsofmugloar.model.game;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


@Data
@Accessors(fluent = true, chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Game {
    private String gameId;
    private int lives;
    private int gold;
    private int level;
    private int score;
    private int highScore;
    private int turn;
    
    public String getGameId() {
        return gameId;
    }
    
    public Game setGameId(String gameId) {
        this.gameId = gameId;
        return this;
    }
    
    public int getLives() {
        return lives;
    }
    
    public Game setLives(int lives) {
        this.lives = lives;
        return this;
    }
    
    public int getGold() {
        return gold;
    }
    
    public Game setGold(int gold) {
        this.gold = gold;
        return this;
    }
    
    public int getLevel() {
        return level;
    }
    
    public Game setLevel(int level) {
        this.level = level;
        return this;
    }
    
    public int getScore() {
        return score;
    }
    
    public Game setScore(int score) {
        this.score = score;
        return this;
    }
    
    public int getHighScore() {
        return highScore;
    }
    
    public Game setHighScore(int highScore) {
        this.highScore = highScore;
        return this;
    }
    
    public int getTurn() {
        return turn;
    }
    
    public Game setTurn(int turn) {
        this.turn = turn;
        return this;
    }
}
