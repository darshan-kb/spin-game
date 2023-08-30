package com.spin.game.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class BetValuesMap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String betName;
    private int betIndex;
    private String betValues;

    public BetValuesMap(){

    }

    public BetValuesMap(String betName, int betIndex, String betValues){
        this.betIndex=betIndex;
        this.betName=betName;
        this.betValues=betValues;
    }
}
