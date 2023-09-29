package com.spin.game.service;

import com.spin.game.dto.UserDTO;
import com.spin.game.entities.ConfirmationToken;
import com.spin.game.entities.User;
import com.spin.game.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class SignUpService {
    UserRepository userRepository;
    BCryptPasswordEncoder bCryptPasswordEncoder;
    //ConfirmationTokenService confirmationTokenService;


    public UserDTO signUpUser(UserDTO user){
        Optional<User> dbUser = userRepository.findByEmail(user.getEmail());
        if(dbUser.isPresent()) {
            throw new IllegalStateException("email already taken");
        }
        return new UserDTO(userRepository.save(new User(user)));
    }

//    public int enableUser(String email) {
//        return userRepository.enableUser(email);
//    }

//    public String createTokenAndSave(User user){
//        String token = UUID.randomUUID().toString();
//        ConfirmationToken confirmationToken = new ConfirmationToken(token, LocalDateTime.now(),LocalDateTime.now().plusMinutes(15),user);
//        confirmationTokenService.saveConfirmationToken(confirmationToken);
//        return token;
//    }
}
