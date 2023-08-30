package com.spin.game.service;

import com.spin.game.entities.Game;
import com.spin.game.model.CountDownModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CountdownService {

    private SimpMessagingTemplate simptemplate;
    private final int countdown;
    private final int initcount;
    private int varcount;
    private int result;
    private Game currentGame;

    private CalculateResultService calculateResultService;
    @Autowired
    private InitGameService initgame;
    public CountdownService(@Value("${countdown}") int countdown, @Value("${initcount}") int initcount, SimpMessagingTemplate simptemplate, CalculateResultService calculateResultService){
        this.countdown = countdown;
        this.initcount = initcount;
        this.simptemplate = simptemplate;
        varcount = countdown;
        this.calculateResultService = calculateResultService;

    }
    @Scheduled(fixedRate = 1000)
    public void countdownStart(){
        if(varcount == countdown){
            Game cGame = initgame.gameInit();
            setCurrentGame(cGame);
        }

        simptemplate.convertAndSend("/topic/countdown", new CountDownModel(varcount));
        System.out.println(varcount);
        varcount -= 1;

        if(varcount == 10){
            result = calculateResultService.getCurrentGameResult(getCurrentGame().getGameId());
        }


        if(varcount == initcount){
            varcount = countdown;
        }
    }

    public int getVarCount(){
        return varcount;
    }

    public Game getCurrentGame() {
        return currentGame;
    }

    public void setCurrentGame(Game currentGame) {
        this.currentGame = currentGame;
    }

    public int getResult(){
        return result;
    }
}
