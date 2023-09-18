package com.spin.game.controller;

import com.spin.game.entities.Game;
import com.spin.game.service.GameReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GameReportController {

    @Autowired
    GameReportService gameReportService;

    @GetMapping(value = "/report/game/records/{records}")
    public List<Game> gameRecords(@RequestParam int records){
        return gameReportService.lastNGames(records);
    }
}
