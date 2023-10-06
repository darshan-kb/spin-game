package com.spin.game.service;

import com.spin.game.dto.ClaimDTO;
import com.spin.game.entities.*;
import com.spin.game.mapper.Mapper;
import com.spin.game.repository.ClaimBetRepository;
import com.spin.game.repository.GameRepo;
import com.spin.game.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ClaimService {
    private ClaimBetRepository claimBetRepository;
    private GameRepo gameRepo;
    private CalculateResultService calculateResultService;
    private UserRepository userRepository;

    @Transactional
    public void addClaim(int result, Game g){
        Game game = gameRepo.findById(g.getGameId()).orElseThrow(()->new IllegalStateException("Game not found"));
        List<Ticket> tickets = game.getTickets();
        if(tickets == null)
            return;
        for(Ticket ticket : tickets){
            User user = ticket.getUser();
            for(Bet bet : ticket.getBets()){
                List<Integer> betElements = calculateResultService.getElements(bet.getBetName(), bet.getValue());
                if(betElements.contains(result)){
                    double payout = calculateResultService.getXTimes(bet.getBetName()) * bet.getAmount();
                    claimBetRepository.save(new ClaimBet(false,payout,bet,game,ticket,user));
                }
            }
        }
    }

    @Transactional
    public List<ClaimDTO> getClaim(String email){
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Email not found"));
        List<ClaimBet> claimBets = claimBetRepository.findAllByUser(user).orElseThrow(() -> new UsernameNotFoundException("User not found in Claim Bets repository"));
        return claimBets.stream().filter(c -> !c.isClaimed()).map(Mapper::toClaimDTO).toList();
    }
}
