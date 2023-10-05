package com.spin.game.service;

import com.spin.game.entities.*;
import com.spin.game.repository.ClaimBetRepository;
import com.spin.game.repository.GameRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ClaimService {
    private ClaimBetRepository claimBetRepository;
    private GameRepo gameRepo;
    private CalculateResultService calculateResultService;

    @Transactional
    public void addClaim(int result, long gameId){
        Game game = gameRepo.findById(gameId).orElseThrow(()-> new IllegalStateException("Game not found"));
        List<Ticket> tickets = game.getTickets();
        for(Ticket ticket : tickets){
            User user = ticket.getUser();
            for(Bet bet : ticket.getBets()){
                List<Integer> betElements = calculateResultService.getElements(bet.getBetName(), bet.getValue());
                if(betElements.contains(result)){
                    double payout = calculateResultService.getXTimes(bet.getBetName()) * bet.getAmount();
                    claimBetRepository.save(new ClaimBet(false,payout,bet));
                }
            }
        }
    }
}
