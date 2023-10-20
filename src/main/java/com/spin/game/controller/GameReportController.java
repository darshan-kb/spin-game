package com.spin.game.controller;

import com.spin.game.entities.Game;
import com.spin.game.service.GameReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GameReportController {

    @Autowired
    GameReportService gameReportService;

    @GetMapping(value = "/report/game/records")
    public List<Game> gameRecords(){
        System.out.println("Report controller");
        return gameReportService.lastNGames(10);
    }

    @GetMapping("/report/game/result")
    public ResponseEntity<Integer> gameResult(){
        System.out.println("Report controller "+gameReportService.lastGameResult());
        return new ResponseEntity<>(gameReportService.lastGameResult(), HttpStatus.OK);
    }
}
