package com.bigbank.hatef.dragonsofmugloar.model.shop;

import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(fluent = true, chain = true)
public class PurchaseResult {
    private String shoppingSuccess;
    private int gold;
    private int lives;
    private int level;
    private int turn;
    
    
    public PurchaseResult setShoppingSuccess(String shoppingSuccess) {
        this.shoppingSuccess = shoppingSuccess;
        return this;
    }
    
    public int getGold() {
        return gold;
    }
    
    public PurchaseResult setGold(int gold) {
        this.gold = gold;
        return this;
    }
    
    public int getLives() {
        return lives;
    }
    
    public PurchaseResult setLives(int lives) {
        this.lives = lives;
        return this;
    }
    
    public int getLevel() {
        return level;
    }
    
    public PurchaseResult setLevel(int level) {
        this.level = level;
        return this;
    }
    
    public int getTurn() {
        return turn;
    }
    
    public PurchaseResult setTurn(int turn) {
        this.turn = turn;
        return this;
    }
}
