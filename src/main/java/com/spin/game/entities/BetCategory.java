package com.spin.game.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BetCategory {
    @Id
    private int id;

    public BetCategory() {
    }

    public BetCategory(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
