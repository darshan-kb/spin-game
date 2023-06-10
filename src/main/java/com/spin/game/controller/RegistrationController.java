package com.spin.game.controller;

import com.spin.game.model.RegistrationRequest;
import com.spin.game.service.EmailSender;
import com.spin.game.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class RegistrationController {
    private RegistrationService registrationService;
    private EmailSender emailSender;
    @PostMapping(value = "/api/registration/signup", consumes = "application/json")
    public String register(@RequestBody RegistrationRequest request){
        return registrationService.register(request);
    }

    @GetMapping("/api/registration/confirm")
    public String confirm(@RequestParam("token") String token){
        return registrationService.confirmToken(token);
    }


}
