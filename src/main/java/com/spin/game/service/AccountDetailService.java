package com.spin.game.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class AccountDetailService {

    @Autowired
    TokenService tokenService;
    public double getBalance(String email){
        RestTemplate restTemplate = new RestTemplate();
        String resourseURL = "http://localhost:7070/account/balance/"+email;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization","Bearer "+tokenService.getToken());
        HttpEntity<String> http = new HttpEntity<>(httpHeaders);
        ResponseEntity<Double> response = restTemplate.exchange(resourseURL, HttpMethod.GET, http, Double.class);
        return response.getBody();
    }

    public void test(){
        RestTemplate restTemplate = new RestTemplate();
        String resourseURL = "http://localhost:8080/hello";
        ResponseEntity<String> response = restTemplate.getForEntity(resourseURL, String.class);
    }
}
