package com.spin.game.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class ClaimBet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long claimBetId;
    private boolean claimed;
    private double amount;
    @OneToOne
    private Bet bet;

    public ClaimBet(boolean claimed, double amount, Bet bet) {
        this.claimed = claimed;
        this.amount = amount;
        this.bet = bet;
    }
}
