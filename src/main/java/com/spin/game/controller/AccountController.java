package com.spin.game.controller;

import com.spin.game.dto.UserDTO;
import com.spin.game.entities.User;
import com.spin.game.service.AccountDetailService;
import com.spin.game.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class AccountController {
    @Autowired
    AccountDetailService accountDetailService;
    @Autowired
    SignUpService signUpService;
    @GetMapping("/account/balance")
    public ResponseEntity<Double> getAccountBalance(Principal p){
        double balance = accountDetailService.getBalance(p.getName());
        return ResponseEntity.ok(balance);
    }
    @PostMapping("/account")
    public ResponseEntity<UserDTO> createAccount(@RequestBody UserDTO user){
        return new ResponseEntity<UserDTO>(signUpService.signUpUser(user), HttpStatus.OK);
    }
}
