package com.spin.game.controller;

import com.spin.game.model.RegistrationRequest;
import com.spin.game.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class RegistrationController {
    private RegistrationService registrationService;
    @PostMapping(value = "/api", consumes = "application/json")
    public String register(@RequestBody RegistrationRequest request){
        return registrationService.register(request);
    }

}
