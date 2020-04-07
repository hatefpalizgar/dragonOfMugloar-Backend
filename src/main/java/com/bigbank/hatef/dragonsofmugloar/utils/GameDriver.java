package com.bigbank.hatef.dragonsofmugloar.utils;

import com.bigbank.hatef.dragonsofmugloar.controller.GameController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class GameDriver {
    
    @Autowired
    private GameController gameController;
    
    @PostConstruct
    public void init() {
        gameController.play();
    }
}
