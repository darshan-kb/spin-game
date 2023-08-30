package com.spin.game.service;

import com.spin.game.model.TicketModel;

import java.util.List;

public interface TicketService {
    public String saveTicket(String email, List<List<Integer>> BoardValues);
}
