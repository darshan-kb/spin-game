package com.spin.game.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class BetCategory {
    @Id
    private int id;

    @OneToMany(mappedBy = "betCategory")
    private List<Bet> bets;

    public BetCategory() {
    }

    public BetCategory(int id) {
        this.id = id;
    }

    public BetCategory(int id, List<Bet> bets) {
        this.id = id;
        this.bets = bets;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Bet> getBets() {
        return bets;
    }

    public void setBets(List<Bet> bets) {
        this.bets = bets;
    }
}
