package com.spin.game.service;

import com.spin.game.payloads.AccountRedeemClaimPayload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HttpRequestService {
    @Value("${redeemClaimURL}")
    private String redeemClaimURL;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private TokenService tokenService;
    Logger logger = LoggerFactory.getLogger(HttpRequestService.class);
    public ResponseEntity<Double> sendPostRequestToRedeemClaim(AccountRedeemClaimPayload accountRedeemClaimPayload){
        logger.info(redeemClaimURL +" "+accountRedeemClaimPayload);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization",tokenService.getAuthTokenFromRequest());
        HttpEntity<String> entity = new HttpEntity(accountRedeemClaimPayload,headers);
        ResponseEntity<Double> response = restTemplate.exchange(redeemClaimURL, HttpMethod.POST, entity, Double.class);
        return response;
    }
}
