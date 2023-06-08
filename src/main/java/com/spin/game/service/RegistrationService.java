package com.spin.game.service;

import com.spin.game.model.RegistrationRequest;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    public String register(RegistrationRequest request){
        return "works";
    }
}
