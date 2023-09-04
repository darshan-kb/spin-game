package com.spin.game.service;

import com.spin.game.entities.Ticket;
import com.spin.game.model.TicketRecordModel;

import java.util.List;

public interface BetService {
    public String saveBet(List<List<Integer>> records, Ticket ticket);
    public void addValueToValueMap(List<List<Integer>> records);
}
