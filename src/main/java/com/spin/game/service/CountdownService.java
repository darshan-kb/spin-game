package com.spin.game.service;

import com.spin.game.model.CountDownModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CountdownService {

    private SimpMessagingTemplate simptemplate;
    private final int countdown;
    private final int initcount;
    private int varcount;
    @Autowired
    private InitGameService initgame;
    public CountdownService(@Value("${countdown}") int countdown, @Value("${initcount}") int initcount, SimpMessagingTemplate simptemplate){
        this.countdown = countdown;
        this.initcount = initcount;
        this.simptemplate = simptemplate;
        varcount = countdown;
    }
    @Scheduled(fixedRate = 1000)
    public void countdownStart(){
        if(varcount == countdown){
            initgame.gameInit();
        }

        simptemplate.convertAndSend("/topic/countdown", new CountDownModel(varcount));

        varcount -= 1;


        if(varcount == initcount){
            varcount = countdown;
        }
    }

    public int getVarCount(){
        return varcount;
    }
}
