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
    private LocalDateTime openTime;
    private LocalDateTime closeTime;
    private int openValue;
    private int closeValue;
    private double totalAmount;
    private double rewardAmount;
    @OneToMany(mappedBy = "game")
    private List<Ticket> tickets;

    public Game() {
    }

    public Game(LocalDateTime openTime, LocalDateTime closeTime, int openValue, int closeValue, double totalAmount, double rewardAmount) {
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.openValue = openValue;
        this.closeValue = closeValue;
        this.totalAmount = totalAmount;
        this.rewardAmount = rewardAmount;
    }

    public Game(long gameId, LocalDateTime openTime, LocalDateTime closeTime, int openValue, int closeValue, double totalAmount, double rewardAmount) {
        this.gameId = gameId;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.openValue = openValue;
        this.closeValue = closeValue;
        this.totalAmount = totalAmount;
        this.rewardAmount = rewardAmount;
    }

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public LocalDateTime getOpenTime() {
        return openTime;
    }

    public void setOpenTime(LocalDateTime openTime) {
        this.openTime = openTime;
    }

    public LocalDateTime getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(LocalDateTime closeTime) {
        this.closeTime = closeTime;
    }

    public int getOpenValue() {
        return openValue;
    }

    public void setOpenValue(int openValue) {
        this.openValue = openValue;
    }

    public int getCloseValue() {
        return closeValue;
    }

    public void setCloseValue(int closeValue) {
        this.closeValue = closeValue;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getRewardAmount() {
        return rewardAmount;
    }

    public void setRewardAmount(double rewardAmount) {
        this.rewardAmount = rewardAmount;
    }
}
