package com.bigbank.hatef.dragonsofmugloar.model.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


@Data
@Accessors(fluent = true, chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private String adId;
    private String message;
    private String reward;
    private int expiresIn;
    private int encrypted;
    private String probability;
    
    public int getDifficulty() {
        switch (probability) {
            case "Piece of cake":
            case "Sure thing":
            case "Walk in the park":
                return Difficulty.BEGINNER.getLevel();
            case "Quite likely":
                return Difficulty.ELEMENTARY.getLevel();
            case "Hmmm....":
                return Difficulty.PREINTERMEDIATE.getLevel();
            case "Risky":
                return Difficulty.LOWINTERMEDIATE.getLevel();
            case "Gamble":
                return Difficulty.INTERMEDIATE.getLevel();
            case "Playing with fire":
                return Difficulty.UPPERINTERMEDIATE.getLevel();
            case "Rather detrimental":
                return Difficulty.PREADVANCED.getLevel();
            case "Suicide mission":
                return Difficulty.ADVANCED.getLevel();
            case "Impossible":
            default:
                return Difficulty.VERYADVANCED.getLevel();
        }
    }
    
    public String getAdId() {
        return adId;
    }
    
    public Message setAdId(String adId) {
        this.adId = adId;
        return this;
    }
    
    public String getMessage() {
        return message;
    }
    
    public Message setMessage(String message) {
        this.message = message;
        return this;
    }
    
    public String getReward() {
        return reward;
    }
    
    public Message setReward(String reward) {
        this.reward = reward;
        return this;
    }
    
    public int getExpiresIn() {
        return expiresIn;
    }
    
    public Message setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
        return this;
    }
    
    public int getEncrypted() {
        return encrypted;
    }
    
    public Message setEncrypted(int encrypted) {
        this.encrypted = encrypted;
        return this;
    }
    
    public String getProbability() {
        return probability;
    }
    
    public Message setProbability(String probability) {
        this.probability = probability;
        return this;
    }
    
    @Override
    public String toString() {
        return "message='" + message + '\'' +
                ", reward='" + reward + '\'' +
                ", expiresIn=" + expiresIn +
                ", probability='" + probability + '\'' +
                '}';
    }
}
