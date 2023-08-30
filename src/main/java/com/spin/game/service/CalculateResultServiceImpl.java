package com.spin.game.service;

import com.spin.game.entities.*;
import com.spin.game.repository.BetCategoryRepository;
import com.spin.game.repository.BetValuesMapRepository;
import com.spin.game.repository.GameRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CalculateResultServiceImpl implements CalculateResultService{
    private GameRepo gameRepo;
    private BetValuesMapRepository betValuesMapRepo;
    private BetCategoryRepository betCategoryRepo;
    private Random random;

    @Override
    @Transactional
    public int getCurrentGameResult(long id) {

        List<Bet> allBets = gameRepo.findById(id).orElseThrow(() -> new IllegalStateException("game not available"))
                .getTickets()
                .stream()
                .flatMap((tickets -> tickets.getBets().stream()))
                .collect(Collectors.toList());

        int totalAmount = allBets.stream().map((bets) -> bets.getAmount()).reduce(0,(previousResult,element)->{
            return previousResult + element;
        });

        List<Integer> validElements = new ArrayList<>();

        for(int i=0;i<37;i++){
            double totalRewardOni=0.0;
            for(Bet b : allBets){
                List<Integer> elements = getElements(b);
                double payout = getXTimes(b.getBetName());
                int amount = b.getAmount();
                if(elements.contains(i)){
                    totalRewardOni += amount * payout;
                }
            }
            //System.out.println(totalRewardOni);
            if(totalRewardOni <= totalAmount*1.0){
                validElements.add(i);
            }
        }

//        Random random = new Random();
        int rand = random.nextInt(validElements.size());

        System.out.println(validElements);
        return validElements.get(rand);
    }

    public List<Integer> getElements(Bet b){
        String betValues = betValuesMapRepo.getElements(b.getBetName(), b.getValue()).orElseThrow(() -> new IllegalStateException("bet is not correct"));
        return Arrays.stream(betValues.split(",")).map((s) -> Integer.parseInt(s)).collect(Collectors.toList());
    }

    public double getXTimes(String betName){
        return betCategoryRepo.getBetCatgoryByBetName(betName).getBetPayout();
    }
}
