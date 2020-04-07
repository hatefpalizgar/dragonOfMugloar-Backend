package com.bigbank.hatef.dragonsofmugloar.model.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


@Data
@Accessors(fluent = true, chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class TaskResult {
    private boolean success;
    private int lives;
    private int gold;
    private int score;
    private int highScore;
    private int turn;
    private String message;
    
    public boolean isSuccess() {
        return success;
    }
    
    public TaskResult setSuccess(boolean success) {
        this.success = success;
        return this;
    }
    
    public int getLives() {
        return lives;
    }
    
    public TaskResult setLives(int lives) {
        this.lives = lives;
        return this;
    }
    
    public int getGold() {
        return gold;
    }
    
    public TaskResult setGold(int gold) {
        this.gold = gold;
        return this;
    }
    
    public int getScore() {
        return score;
    }
    
    public TaskResult setScore(int score) {
        this.score = score;
        return this;
    }
    
    public int getHighScore() {
        return highScore;
    }
    
    public TaskResult setHighScore(int highScore) {
        this.highScore = highScore;
        return this;
    }
    
    public int getTurn() {
        return turn;
    }
    
    public TaskResult setTurn(int turn) {
        this.turn = turn;
        return this;
    }
    
    public String getMessage() {
        return message;
    }
    
    public TaskResult setMessage(String message) {
        this.message = message;
        return this;
    }
}
