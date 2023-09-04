package com.spin.game.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

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
