package com.spin.game.service;

import com.spin.game.entities.*;
import com.spin.game.model.TicketModel;
import com.spin.game.model.TicketRecordModel;
import com.spin.game.repository.TicketRepository;
import com.spin.game.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class TicketServiceImpl implements TicketService{

    private UserRepository userRepository;
    private BetCategory betCategory;
    private CountdownService countdownService;
    private TicketRepository ticketRepository;
    @Override
    @Transactional
    public String saveTicket(String email, TicketModel ticketModel) {
        User user = userRepository.findByEmail(email).get();
        Game game = countdownService.getCurrentGame();
        double totalAmt = calTotalAmt(ticketModel);
        ticketRepository.save(new Ticket(LocalDateTime.now(),totalAmt,game,user));
//        ticketModel.getTicketRecords().stream().map(ticketRecordModel ->{
//            Bet bet = new Bet()
//        });
        return null;
    }

    public double calTotalAmt(TicketModel ticketModel){
        double amt=0.0;
        for(TicketRecordModel ticketRecordModel : ticketModel.getTicketRecords()){
            amt+=ticketRecordModel.getBetValue();
        }
        return amt;
    }
}
