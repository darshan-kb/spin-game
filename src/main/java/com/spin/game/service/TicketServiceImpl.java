package com.spin.game.service;

import com.spin.game.entities.*;
import com.spin.game.model.TicketModel;
import com.spin.game.model.TicketRecordModel;
import com.spin.game.repository.BetRepository;
import com.spin.game.repository.TicketRepository;
import com.spin.game.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TicketServiceImpl implements TicketService{

    private UserRepository userRepository;
    private CountdownService countdownService;
    private TicketRepository ticketRepository;
    private BetService betService;
    @Override
    @Transactional
    public String saveTicket(String email, TicketModel ticketModel) {
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isEmpty()){
            throw new IllegalStateException("user not found");
        }
        Game game = countdownService.getCurrentGame();
        double totalAmt = calTotalAmt(ticketModel);
        Ticket t = ticketRepository.save(new Ticket(LocalDateTime.now(),totalAmt,game,user.get()));
        betService.saveBet(ticketModel.getTicketRecords(),t);
        return "success";
    }

    public double calTotalAmt(TicketModel ticketModel){
        double amt=0.0;
        for(TicketRecordModel ticketRecordModel : ticketModel.getTicketRecords()){
            amt+=ticketRecordModel.getBetValue();
        }
        return amt;
    }
}
