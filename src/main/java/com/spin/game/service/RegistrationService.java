package com.spin.game.service;

import com.spin.game.entities.User;
import com.spin.game.model.RegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {
    SignUpService signUpService;
    public String register(RegistrationRequest request){

        String token = signUpService.signUpUser(
                new User(
                        request.getFirstName(),
                        request.getLastName(),
                        request.getPassword(),
                        request.getEmail(),
                        "ROLE_USER"
                )
        );
        return token;
    }


}
