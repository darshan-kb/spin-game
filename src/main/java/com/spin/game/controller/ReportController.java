package com.spin.game.controller;

import com.spin.game.dto.TicketReportDTO;
import com.spin.game.service.GameReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/report")
public class ReportController {
    @Autowired
    GameReportService gameReportService;
    @GetMapping("/ticket/{page}")
    public ResponseEntity<List<TicketReportDTO>> getTickets(@PathVariable Integer page, Principal principal){
        return new ResponseEntity<List<TicketReportDTO>>(gameReportService.getTickets(page,principal.getName()), HttpStatus.OK);
    }

    @GetMapping("/ticket/pages")
    public ResponseEntity<Long> getTotalPages(Principal p){
        long pages = (long) Math.ceil((gameReportService.totalTickets(p.getName())/10.0));
        return new ResponseEntity<>(pages, HttpStatus.OK);
    }
}
