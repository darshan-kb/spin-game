package com.spin.game.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

public class Bet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long betId;
    @ManyToOne
    private Ticket ticketId;
    private int point;
    @ManyToOne
    private BetCategory betCategory;

    public Bet() {
    }

    public Bet(long betId, Ticket ticketId, int point, BetCategory betCategory) {
        this.betId = betId;
        this.ticketId = ticketId;
        this.point = point;
        this.betCategory = betCategory;
    }

    public long getBetId() {
        return betId;
    }

    public void setBetId(long betId) {
        this.betId = betId;
    }

    public Ticket getTicketId() {
        return ticketId;
    }

    public void setTicketId(Ticket ticketId) {
        this.ticketId = ticketId;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public BetCategory getBetCategory() {
        return betCategory;
    }

    public void setBetCategory(BetCategory betCategory) {
        this.betCategory = betCategory;
    }
}
