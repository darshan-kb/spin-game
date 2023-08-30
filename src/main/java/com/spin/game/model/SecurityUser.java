package com.spin.game.model;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.spin.game.entities.User;

import java.util.Arrays;
import java.util.Collection;

public class SecurityUser{
    private final User user;

    public SecurityUser(User user){
        this.user = user;
    }


}