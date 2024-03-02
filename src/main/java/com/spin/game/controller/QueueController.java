package com.spin.game.controller;

import com.spin.game.config.beans.ResultQueue;
import com.spin.game.payloads.QueuePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Queue;

@RestController
public class QueueController {
    @Autowired
    ResultQueue resultQueue;

    @GetMapping("/queue")
    public ResponseEntity<Queue<QueuePayload>> getResultQueue(){
        return new ResponseEntity<>(resultQueue.getQueue(), HttpStatus.OK);
    }
}
