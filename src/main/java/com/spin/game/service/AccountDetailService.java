package com.spin.game.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class AccountDetailService {
    public void getBalance(){

    }

    public void test(){
        RestTemplate restTemplate = new RestTemplate();
        String resourseURL = "http://localhost:8080/hello";
        ResponseEntity<String> response = restTemplate.getForEntity(resourseURL, String.class);
    }
}
