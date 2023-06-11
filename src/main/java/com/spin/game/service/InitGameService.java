package com.spin.game.service;

import com.spin.game.entities.Game;
import com.spin.game.repository.GameRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class InitGameService {
    @Autowired
    private GameRepo gamerepo;
    @Value("${countdown}")
    private int timeGap;
    public Game gameInit(){
        LocalDateTime openTime = LocalDateTime.now();
        LocalDateTime closeTime = openTime.plusMinutes(timeGap/60);
        return gamerepo.save(new Game(openTime,closeTime,0,0,0.0,0.0));
    }

}
