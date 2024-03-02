package com.spin.game.service.websocketservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class WebsocketResultService {

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;
    public void sendResult(int result){
        simpMessagingTemplate.convertAndSend("/result/data",result);
    }
}
