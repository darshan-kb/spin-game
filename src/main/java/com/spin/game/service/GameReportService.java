package com.spin.game.service;

import com.spin.game.entities.Game;
import com.spin.game.entities.Ticket;

import java.util.List;

public interface GameReportService {
    public List<Game> lastNGames(int n);
    public List<Ticket> getTickets(int page, String email);
}
