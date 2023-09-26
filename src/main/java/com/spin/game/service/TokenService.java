package com.spin.game.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.stereotype.Service;

@Service
public class TokenService {
    @Autowired
    private OAuth2AuthorizedClientManager oAuth2AuthorizedClientManager;
    String getToken(){
        OAuth2AuthorizeRequest request = OAuth2AuthorizeRequest
                .withClientRegistrationId("2")
                .principal("spin-client")
                .build();

        OAuth2AuthorizedClient client = oAuth2AuthorizedClientManager.authorize(request);
        System.out.println(client.getAccessToken().getTokenValue());
        return client.getAccessToken().getTokenValue();
    }
}
