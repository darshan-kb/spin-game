package com.spin.game.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;
    private String firstname;
    private String lastname;
    private String email;
    @OneToMany(mappedBy = "user")
    private List<Ticket> tickets;

    public User() {
    }

    public User(long userId, String firstname, String lastname) {
        this.userId = userId;
        this.firstname = firstname;
    }

    public User(String firstname, String lastname, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public User(String firstname, String lastname, String password, String email, boolean locked, boolean enabled, String roles) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public User(String firstname, String lastname, String password, String roles) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstnamename) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
