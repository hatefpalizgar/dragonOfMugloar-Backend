package com.bigbank.hatef.dragonsofmugloar.model.game;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


@Data
@Accessors(fluent = true, chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Reputation {
    private double people;
    private double state;
    private double underworld;
    
    public double getPeople() {
        return people;
    }
    
    public Reputation setPeople(double people) {
        this.people = people;
        return this;
    }
    
    public double getState() {
        return state;
    }
    
    public Reputation setState(double state) {
        this.state = state;
        return this;
    }
    
    public double getUnderworld() {
        return underworld;
    }
    
    public Reputation setUnderworld(double underworld) {
        this.underworld = underworld;
        return this;
    }
}
