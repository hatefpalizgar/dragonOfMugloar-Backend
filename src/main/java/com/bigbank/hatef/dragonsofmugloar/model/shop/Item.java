package com.bigbank.hatef.dragonsofmugloar.model.shop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


@Data
@Accessors(fluent = true, chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    private String id;
    private String name;
    private double cost;
    
    public String getId() {
        return id;
    }
    
    public Item setId(String id) {
        this.id = id;
        return this;
    }
    
    public String getName() {
        return name;
    }
    
    public Item setName(String name) {
        this.name = name;
        return this;
    }
    
    public double getCost() {
        return cost;
    }
    
    public Item setCost(double cost) {
        this.cost = cost;
        return this;
    }
}
