package com.spin.game.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CountdownService {

    private final int countdown;
    private int varcount;
    public CountdownService(@Value("${countdown}") int countdown){
        this.countdown = countdown;
        varcount = countdown;
    }
    @Scheduled(fixedRate = 1000)
    public void countdownStart(){

    }

    public int getVarCount(){
        return varcount;
    }
}
