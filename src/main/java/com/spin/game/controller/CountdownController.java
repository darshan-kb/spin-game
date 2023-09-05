package com.spin.game.controller;

import com.spin.game.model.CountDownModel;
import com.spin.game.service.CountdownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountdownController {

    @Autowired
    CountdownService countdownService;
//    @MessageMapping("/ws/countdown")
//    @SendTo("/topic/countdown")
//    public void greeting() throws Exception {
//        System.out.println("Hello from server");
//    }

    @GetMapping("/countdown")
    public CountDownModel CountdownSend(){
        //System.out.println("Here ");
        return new CountDownModel(countdownService.getVarCount());
    }

    @GetMapping("/result")
    public int getResult(){
        System.out.println("In result controller");
        return countdownService.getResult();
    }

}
