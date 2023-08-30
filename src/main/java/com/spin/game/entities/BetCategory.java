package com.spin.game.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class BetCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String betName;
    private double betPayout;

    public BetCategory() {
    }

    public BetCategory(String betName, double betPayout) {
        this.betName = betName;
        this.betPayout = betPayout;
    }


}
