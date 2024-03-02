package com.spin.game.config.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Countdown {
    private final int startCount;
    private int countdown;

    public Countdown(@Value("${countdown}") int beginCount){
        countdown = beginCount;
        startCount = beginCount;
    }

    public int getCountdown() {
        return countdown;
    }

    public void reset(){
        countdown=startCount;
    }

    public void decrement(){
        countdown--;
    }
}
