package com.bigbank.hatef.dragonsofmugloar.service;

import com.bigbank.hatef.dragonsofmugloar.model.shop.Item;
import com.bigbank.hatef.dragonsofmugloar.model.shop.PurchaseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class ShopService {
    Logger logger = LoggerFactory.getLogger(ShopService.class);
    
    @Autowired
    RestTemplate restTemplate;
    
    public List<Item> getAllItems(String gameId) {
        String url = "https://dragonsofmugloar.com/api/v2/" + gameId + "/shop";
        try {
            Item[] items = restTemplate.getForObject(url, Item[].class);
            return Arrays.asList(items != null ? items : new Item[0]);
        } catch (HttpClientErrorException e) {
            logger.error(e.getMessage());
            return new ArrayList<>();
        }
    }
    
    public PurchaseResult purchase(String gameId, String itemId) {
        String url = "https://dragonsofmugloar.com/api/v2/" + gameId + "/shop/buy/" + itemId;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        try {
            PurchaseResult result = restTemplate.postForObject(url, headers, PurchaseResult.class);
            logger.info("item [" + itemId + "] purchased");
            return result;
        } catch (HttpClientErrorException e) {
            logger.error(e.getMessage());
            return new PurchaseResult();
        }
    }
}
