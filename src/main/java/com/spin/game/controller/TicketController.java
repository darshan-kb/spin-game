package com.spin.game.controller;

import com.spin.game.model.TicketModel;
import com.spin.game.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TicketController {
    private TicketService ticketService;
    @PostMapping("/api/ticket/saveticket")
    public String saveTicket(@RequestBody TicketModel ticketModel){
        Authentication a = SecurityContextHolder.getContext().getAuthentication();
        return ticketService.saveTicket(a.getName(),ticketModel);
    }
}
