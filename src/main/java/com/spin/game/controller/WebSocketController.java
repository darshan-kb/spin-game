package com.spin.game.controller;

import com.spin.game.config.beans.Countdown;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    @Autowired
    private Countdown countdown;

    @SendTo("/countdown/count")
    public void countDown(){
        for(int i=0;i<5;i++){
            try{
                Thread.sleep(1000);
                simpMessagingTemplate.convertAndSend("/countdown/count",countdown.getCountdown());
            }
            catch(Exception e){

            }
        }
    }
}
