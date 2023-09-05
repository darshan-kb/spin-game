package com.spin.game.controller;


import com.spin.game.service.SseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
public class SseEventController {
    @Autowired
    SseService sseService;
    @GetMapping(value = "/sse", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter eventStream(){
        SseEmitter emitter = new SseEmitter();
        sseService.addEmitter(emitter);
        return emitter;
    }
}
