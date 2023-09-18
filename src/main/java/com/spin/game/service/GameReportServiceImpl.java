package com.spin.game.service;

import com.spin.game.entities.Game;
import com.spin.game.repository.GameRepo;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GameReportServiceImpl implements GameReportService{

    private GameRepo gameRepo;

    @Override
    public List<Game> lastNGames(int n) {
        return gameRepo.findAll(PageRequest.of(0,n, Sort.by("gameTimeStamp").descending())).toList();
    }
}
