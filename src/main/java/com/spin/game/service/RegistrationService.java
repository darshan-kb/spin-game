package com.spin.game.service;

import com.spin.game.entities.ConfirmationToken;
import com.spin.game.entities.User;
import com.spin.game.model.RegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RegistrationService {
    private final SignUpService signUpService;
    private final ConfirmationTokenService confirmationTokenService;
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

    @Transactional
    public String confirmToken(String token){
        ConfirmationToken confirmationToken = confirmationTokenService.getToken(token)
                .orElseThrow(()->new IllegalStateException("token not found"));

        if(confirmationToken.getConfirmedAt()!=null){
            throw new IllegalStateException("email already confirmed");
        }

        LocalDateTime expiredAt = confirmationToken.getExpiresAt();

        if(expiredAt.isBefore(LocalDateTime.now())){
            throw new IllegalStateException("token expired");
        }

        confirmationTokenService.setConfirmedAt(token);

        return signUpService.enableUser(confirmationToken.getUser().getEmail())==2 ? "confirmed" : "couldn't register";
    }


}
