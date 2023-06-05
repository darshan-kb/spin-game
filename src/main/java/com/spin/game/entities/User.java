package com.spin.game.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;
    private String username;
    private String password;
    private String Roles;
    @OneToMany(mappedBy = "user")
    private List<Ticket> tickets;

    public User() {
    }

    public User(long userId, String username, String password, String roles) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        Roles = roles;
    }

    public User(String username, String password, String roles) {
        this.username = username;
        this.password = password;
        Roles = roles;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return Roles;
    }

    public void setRoles(String roles) {
        Roles = roles;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
