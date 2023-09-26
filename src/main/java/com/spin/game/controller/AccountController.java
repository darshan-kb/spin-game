package com.spin.game.controller;

import com.spin.game.service.AccountDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class AccountController {
    @Autowired
    AccountDetailService accountDetailService;
    @GetMapping("/account/balance")
    public ResponseEntity<Double> getAccountBalance(Principal p){
        double balance = accountDetailService.getBalance(p.getName());
        return ResponseEntity.ok(balance);
    }
}
