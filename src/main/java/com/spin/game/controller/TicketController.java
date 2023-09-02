package com.spin.game.controller;

import com.spin.game.model.TicketModel;
import com.spin.game.payloads.ApiResponse;
import com.spin.game.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ApiResponse> saveTicket(@RequestBody List<List<Integer>> BoardValues){
        Authentication a = SecurityContextHolder.getContext().getAuthentication();
        ticketService.saveTicket(a.getName(),BoardValues);
        return new ResponseEntity<ApiResponse>(new ApiResponse("ticket added", true), HttpStatus.OK);
    }
}
