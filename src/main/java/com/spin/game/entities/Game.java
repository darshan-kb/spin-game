package com.spin.game.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long gameId;
    private Date openTime;
    private Date closeTime;
    private int openValue;
    private int closeValue;
    private double totalAmount;
    private double rewardAmount;
    @OneToMany(mappedBy = "game")
    private List<Ticket> tickets;

    public Game() {
    }

    public Game(long gameId, Date openTime, Date closeTime, int openValue, int closeValue, double totalAmount, double rewardAmount) {
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

    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
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
