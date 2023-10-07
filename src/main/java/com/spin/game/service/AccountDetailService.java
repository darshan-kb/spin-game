package com.spin.game.service;

import com.spin.game.payloads.AddTicketPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class AccountDetailService {
    @Value("${balanceURL}")
    private String balanceURL;
    @Value("${addURL}")
    private String addURL;
    @Value("${ticketErrorURL}")
    private String ticketErrorURL;

    @Autowired
    TokenService tokenService;
    public double getBalance(String email){
        RestTemplate restTemplate = new RestTemplate();
        String resourseURL = balanceURL+email;
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

    public double addTicket(long amount, String email, long ticketId){

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization","Bearer "+tokenService.getToken());
        HttpEntity<String> entity = new HttpEntity(new AddTicketPayload(amount*1.0, email, "ticketId:"+ticketId),headers);

        ResponseEntity<Double> response = restTemplate.exchange(addURL, HttpMethod.POST, entity, Double.class);
        System.out.println(response.getBody());
        return response.getBody();

    }

    public double ticketError(long amount, String email){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization","Bearer "+tokenService.getToken());
        HttpEntity<String> entity = new HttpEntity(new AddTicketPayload(amount*1.0, email),headers);

        ResponseEntity<Double> response = restTemplate.exchange(ticketErrorURL, HttpMethod.POST, entity, Double.class);
        System.out.println(response.getBody());
        return response.getBody();
    }
}
