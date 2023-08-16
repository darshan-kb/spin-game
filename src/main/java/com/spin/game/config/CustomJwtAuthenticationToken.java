package com.spin.game.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import java.util.Collection;

public class CustomJwtAuthenticationToken extends JwtAuthenticationToken {

    private String customVariable;
    public CustomJwtAuthenticationToken(Jwt jwt, Collection<? extends GrantedAuthority> authorities) {
        super(jwt, authorities);
        customVariable = "This is custom paramter in JwtAuthenticationToken";
    }
}
