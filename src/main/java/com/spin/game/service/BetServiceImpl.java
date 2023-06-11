package com.spin.game.service;

import com.spin.game.entities.Bet;
import com.spin.game.entities.Ticket;
import com.spin.game.model.TicketRecordModel;
import com.spin.game.repository.BetCategoryRepository;
import com.spin.game.repository.BetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class BetServiceImpl implements BetService{

    private BetRepository betRepository;
    private BetCategoryRepository betCategoryRepository;
    @Override
    public String saveBet(List<TicketRecordModel> records, Ticket ticket) {
        records.stream().map(ticketRecordModel ->
                new Bet(ticket,ticketRecordModel.getBetValue(),betCategoryRepository.findById(ticketRecordModel.getBetCat()).get())
        ).forEach(betRepository::save);
        return "Success";
    }
}
