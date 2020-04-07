package com.bigbank.hatef.dragonsofmugloar.model.message;

import lombok.Getter;


@Getter
public enum Difficulty {
    BEGINNER(1),
    ELEMENTARY(2),
    PREINTERMEDIATE(3),
    LOWINTERMEDIATE(4),
    INTERMEDIATE(5),
    UPPERINTERMEDIATE(6),
    PREADVANCED(7),
    ADVANCED(8),
    VERYADVANCED(9);
    
    private int level;
    
    Difficulty(int level) {
        this.level = level;
    }
    
}
