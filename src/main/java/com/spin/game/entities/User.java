package com.spin.game.entities;

import com.spin.game.dto.UserDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;
    private String username;
    private String email;
    private String role;
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Ticket> tickets;
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<ClaimBet> claimBets;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public User(UserDTO user){
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.role = user.getRole();
    }

}
