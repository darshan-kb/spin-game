package com.spin.game.service;

import com.spin.game.entities.Bet;
import com.spin.game.entities.Ticket;
import com.spin.game.model.TicketRecordModel;
import com.spin.game.repository.BetCategoryRepository;
import com.spin.game.repository.BetRepository;
import com.spin.game.serviceclass.ValueMap;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class BetServiceImpl implements BetService{

    //Logger LOGGER = Logger.getLogger(BetServiceImpl.class);

    private final List<String> betNames = List.of("single","vSplit","row","hSplit","corner","zero","half","dozen","mis","column");

    private BetRepository betRepository;
    private BetCategoryRepository betCategoryRepository;
    private CountdownService countdownService;
    private ValueMap valueMap;
    @Override
    @Transactional
    public String saveBet(List<List<Integer>> records, Ticket ticket) {
        for(int i=0;i<records.size();i++){
            for(int j=0;j<records.get(i).size();j++){
                int amount = records.get(i).get(j)*10;
                if(amount>0) {
                    Bet b = new Bet(ticket, j, amount, betNames.get(i));
                    betRepository.save(b);
                }
            }
        }
        //records.stream().forEach((record) -> record.forEach());
//        records.stream().map(ticketRecordModel ->
//                new Bet(ticket,ticketRecordModel.getBetValue(),betCategoryRepository.findById(ticketRecordModel.getBetCat()).get())
//        ).forEach(betRepository::save);
        return "Success";
    }

    @Override
    @Transactional
    public void addValueToValueMap(List<List<Integer>> records) {
        //ValueMap valueMap = countdownService.getValueMap();
        for(int i=0;i<records.size();i++){
            for(int j=0;j<records.get(i).size();j++){
                int amount = records.get(i).get(j);
                if(amount>0) {
                    valueMap.addValueToIndex(betNames.get(i),j,amount);
                }
            }
        }
        System.out.println(valueMap+"here");
    }


}
