package com.spin.game.service.websocketservice;

import com.spin.game.config.beans.ResultQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class WebsocketQueueService {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    @Autowired
    private ResultQueue queue;

    public void sendQueue(){
        simpMessagingTemplate.convertAndSend("/queue/data",queue.getQueue());
    }
}
