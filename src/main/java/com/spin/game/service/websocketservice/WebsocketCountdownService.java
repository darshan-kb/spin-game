package com.spin.game.service.websocketservice;


import com.spin.game.config.beans.Countdown;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class WebsocketCountdownService {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    @Autowired
    private Countdown countdown;

    public void sendCountdown(){
        simpMessagingTemplate.convertAndSend("/countdown/count",countdown.getCountdown());
    }
}
