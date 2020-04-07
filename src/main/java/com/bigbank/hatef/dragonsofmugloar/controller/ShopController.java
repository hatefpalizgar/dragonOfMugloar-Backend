package com.bigbank.hatef.dragonsofmugloar.controller;

import com.bigbank.hatef.dragonsofmugloar.model.shop.Item;
import com.bigbank.hatef.dragonsofmugloar.model.shop.PurchaseResult;
import com.bigbank.hatef.dragonsofmugloar.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;


@Component
public class ShopController {
    
    @Autowired
    ShopService shopService;
    
    public List<Item> getAvailableItems(String gameId) {
        return shopService.getAllItems(gameId);
    }
    
    public PurchaseResult purchase(String gameId, String itemId) {
        return shopService.purchase(gameId, itemId);
    }
    
    public PurchaseResult purchaseRandom(String gameId) {
        List<Item> itemList = getAvailableItems(gameId);
        String randomId = itemList.get(new Random().nextInt(itemList.size())).getId();
        return purchase(gameId, randomId);
    }
}
