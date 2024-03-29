package com.spin.game.service;

import com.spin.game.config.beans.Countdown;
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
    private Countdown countdown;

    @Override
    @Transactional
    public double saveTicket(String email, List<List<Integer>> boardValues) {
        var user = userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException());

        if(countdown.getCountdown()<=10)
            throw new DrawCloseException();

        Game game = countdownService.getCurrentGame();
        long gameTotalAmt = game.getTotalAmount();
        int totalAmt = boardValues.stream().flatMap((bv)->bv.stream()).reduce(0, (previousresult, element)-> previousresult + element);
        totalAmt*=10;

        //try{
            Ticket t = ticketRepository.save(new Ticket(LocalDateTime.now(),totalAmt,game,user));
            betService.saveBet(boardValues,t);
            betService.addValueToValueMap(boardValues);
            game.setTotalAmount(gameTotalAmt+totalAmt);
            gameRepo.save(game);
        //}
//        catch(RuntimeException e){
//            balance = accountDetailService.ticketError(totalAmt,email);
//            throw new RuntimeException();
//        }
        double balance;
        try{
            balance = accountDetailService.addTicket(totalAmt, t.getTicketId());
        }
        catch(Exception e){
            throw new RuntimeException("ticket is not created");
        }

        return balance;
    }


}
