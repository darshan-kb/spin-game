package com.spin.game.service;

import com.spin.game.model.TicketModel;

public interface TicketService {
    public String saveTicket(String email, TicketModel ticketModel);
}
