package com.spin.game.service;

import com.spin.game.entities.Game;
import com.spin.game.repository.GameRepo;
import com.spin.game.serviceclass.ValueMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class InitGameService {
    @Autowired
    private GameRepo gamerepo;
    @Autowired
    private ValueMap valueMap;

    @Value("${countdown}")
    private int timeGap;
    @Transactional
    public Game gameInit(){
        LocalDateTime startTime = LocalDateTime.now();
        valueMap.initializeValueMap();
        return gamerepo.save(new Game(startTime,0,0));
    }

}
