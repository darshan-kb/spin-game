package com.spin.game.service;

import com.spin.game.entities.*;
import com.spin.game.exception.DrawCloseException;
import com.spin.game.exception.UserNotFoundException;
import com.spin.game.model.TicketModel;
import com.spin.game.model.TicketRecordModel;
import com.spin.game.repository.BetRepository;
import com.spin.game.repository.GameRepo;
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
    private GameRepo gameRepo;
    private AccountDetailService accountDetailService;

    @Override
    @Transactional
    public double saveTicket(String email, List<List<Integer>> boardValues) {
        var user = userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException());

        if(countdownService.getVarCount()<=10)
            throw new DrawCloseException();

        Game game = countdownService.getCurrentGame();
        long gameTotalAmt = game.getTotalAmount();
        int totalAmt = boardValues.stream().flatMap((bv)->bv.stream()).reduce(0, (previousresult, element)-> previousresult + element);
        double balance = accountDetailService.addTicket(totalAmt*10, email);
        Ticket t = ticketRepository.save(new Ticket(LocalDateTime.now(),totalAmt,game,user));
        betService.saveBet(boardValues,t);
        betService.addValueToValueMap(boardValues);
        game.setTotalAmount(gameTotalAmt+totalAmt);
        gameRepo.save(game);
        return balance;
    }


}
