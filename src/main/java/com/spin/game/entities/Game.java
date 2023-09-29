package com.spin.game.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long gameId;

    private LocalDateTime gameTimeStamp;

    private int resultValue;
    private long totalAmount;

    @OneToMany(mappedBy = "game", cascade = CascadeType.REMOVE)
    private List<Ticket> tickets;

    public Game() {
    }

    public Game(LocalDateTime gameTimeStamp, int resultValue, long totalAmount) {
        this.gameTimeStamp = gameTimeStamp;
        this.resultValue = resultValue;
        this.totalAmount = getTotalAmount();
    }

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public LocalDateTime getGameTimeStamp() {
        return gameTimeStamp;
    }

    public void setGameTimeStamp(LocalDateTime gameTimeStamp) {
        this.gameTimeStamp = gameTimeStamp;
    }

    public int getResultValue() {
        return resultValue;
    }

    public void setResultValue(int resultValue) {
        this.resultValue = resultValue;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(long totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Game{" +
                "gameId=" + gameId +
                ", gameTimeStamp=" + gameTimeStamp +
                ", resultValue=" + resultValue +
                ", tickets=" + tickets +
                '}';
    }
}
