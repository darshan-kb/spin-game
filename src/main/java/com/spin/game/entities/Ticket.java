package com.spin.game.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ticketId;

    private Date timestamp;

    private double totalAmount;

    @ManyToOne
    private Game game;
    @ManyToOne
    private User user;

    public Ticket() {
    }

    public Ticket(long ticketId, Date timestamp, double totalAmount, Game game, User user) {
        this.ticketId = ticketId;
        this.timestamp = timestamp;
        this.totalAmount = totalAmount;
        this.game = game;
        this.user = user;
    }

    public long getTicketId() {
        return ticketId;
    }

    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}