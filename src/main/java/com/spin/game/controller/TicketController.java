package com.spin.game.controller;

import com.spin.game.model.TicketModel;
import com.spin.game.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class TicketController {
    private TicketService ticketService;

    @GetMapping("/hello/server")
    public String Hello(){
        return "Hello from server";
    }
    @PostMapping("/api/ticket/saveticket")
    public String saveTicket(@RequestBody List<List<Integer>> BoardValues){
        Authentication a = SecurityContextHolder.getContext().getAuthentication();
        return ticketService.saveTicket(a.getName(),BoardValues);
    }
}
