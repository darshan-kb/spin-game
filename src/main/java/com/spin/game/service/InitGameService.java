package com.spin.game.service;

import com.spin.game.entities.Game;
import com.spin.game.repository.GameRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class InitGameService {
    @Autowired
    private GameRepo gamerepo;
    @Value("${countdown}")
    private int timeGap;
    public long gameInit(){
        Calendar currentTimeNow = Calendar.getInstance();
        Date openTime = currentTimeNow.getTime();
        Date closeTime = timeAfterNMin(currentTimeNow,timeGap/60);
        Game savedGame = gamerepo.save(new Game(openTime,closeTime,0,0,0.0,0.0));
        return savedGame.getGameId();
    }

    public Date timeAfterNMin(Calendar currentTimeNow, int tmin){
        currentTimeNow.add(Calendar.MINUTE, tmin);
        return currentTimeNow.getTime();
    }
}
