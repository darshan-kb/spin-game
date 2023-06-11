package com.spin.game.entities;

import jakarta.persistence.*;

@Entity
public class Bet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long betId;
    @ManyToOne
    private Ticket ticket;
    private int point;
    @ManyToOne
    private BetCategory betCategory;

    public Bet() {
    }

    public Bet(long betId, Ticket ticket, int point, BetCategory betCategory) {
        this.betId = betId;
        this.ticket = ticket;
        this.point = point;
        this.betCategory = betCategory;
    }

    public Bet(Ticket ticket, int point, BetCategory betCategory) {
        this.ticket = ticket;
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
        return ticket;
    }

    public void setTicketId(Ticket ticketId) {
        this.ticket = ticketId;
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
