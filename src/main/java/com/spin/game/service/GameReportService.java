package com.spin.game.service;

import com.spin.game.entities.Game;

import java.util.List;

public interface GameReportService {
    public List<Game> lastNGames(int n);
}
