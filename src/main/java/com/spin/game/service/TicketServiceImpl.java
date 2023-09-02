package com.spin.game.service;

import com.spin.game.entities.*;
import com.spin.game.exception.DrawCloseException;
import com.spin.game.model.TicketModel;
import com.spin.game.model.TicketRecordModel;
import com.spin.game.repository.BetRepository;
import com.spin.game.repository.TicketRepository;
import com.spin.game.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
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
    public String saveTicket(String email, List<List<Integer>> boardValues) {
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isEmpty()){
            throw new IllegalStateException("user not found");
        }
        if(countdownService.getVarCount()<=10)
            throw new DrawCloseException();

        Game game = countdownService.getCurrentGame();
        int totalAmt = boardValues.stream().flatMap((bv)->bv.stream()).reduce(0, (previousresult, element)-> previousresult + element);
        Ticket t = ticketRepository.save(new Ticket(LocalDateTime.now(),totalAmt,game,user.get()));
        betService.saveBet(boardValues,t);
        return "success";
    }


}
