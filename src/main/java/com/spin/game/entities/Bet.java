package com.spin.game.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Bet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long betId;
    @ManyToOne
    private Ticket ticket;
    private int value;
    private int amount;
    private String betName;

    public Bet() {
    }

    public Bet(Ticket ticket, int value, int amount, String betName) {
        this.ticket = ticket;
        this.value = value;
        this.amount = amount;
        this.betName = betName;
    }

    @Override
    public String toString() {
        return "Bet{" +
                "betId=" + betId +
//                ", ticket=" + ticket +
                ", value=" + value +
                ", amount=" + amount +
                ", betName='" + betName + '\'' +
                '}';
    }
}
