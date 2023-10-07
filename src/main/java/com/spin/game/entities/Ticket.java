package com.spin.game.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ticketId;

    private LocalDateTime timestamp;

    private double totalAmount;

    @ManyToOne
    private Game game;
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "ticket", cascade = CascadeType.REMOVE)
    private List<Bet> bets;
    @OneToMany(mappedBy = "ticket", cascade = CascadeType.REMOVE)
    private List<ClaimBet> claimBets;

    public Ticket() {
    }

    public Ticket(long ticketId, LocalDateTime timestamp, double totalAmount, Game game, User user) {
        this.ticketId = ticketId;
        this.timestamp = timestamp;
        this.totalAmount = totalAmount;
        this.game = game;
        this.user = user;
    }

    public Ticket(long ticketId, LocalDateTime timestamp, double totalAmount, Game game, User user, List<Bet> bets) {
        this.ticketId = ticketId;
        this.timestamp = timestamp;
        this.totalAmount = totalAmount;
        this.game = game;
        this.user = user;
        this.bets = bets;
    }

    public Ticket(LocalDateTime timestamp, double totalAmount, Game game, User user) {
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

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
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

    public List<Bet> getBets() {
        return bets;
    }

    public void setBets(List<Bet> bets) {
        this.bets = bets;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", timestamp=" + timestamp +
                ", totalAmount=" + totalAmount +
//                ", game=" + game +
                ", user=" + user +
                ", bets=" + bets +
                '}';
    }
}