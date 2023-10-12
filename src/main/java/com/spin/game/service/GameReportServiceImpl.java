package com.spin.game.service;

import com.spin.game.entities.Game;
import com.spin.game.entities.Ticket;
import com.spin.game.entities.User;
import com.spin.game.exception.UserNotFoundException;
import com.spin.game.repository.GameRepo;
import com.spin.game.repository.TicketRepository;
import com.spin.game.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@AllArgsConstructor
public class GameReportServiceImpl implements GameReportService{
    private final GameRepo gameRepo;
    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;

    @Override
    public List<Game> lastNGames(int n) {
        return gameRepo.findAll(PageRequest.of(0,n, Sort.by("gameTimeStamp").descending())).toList();
    }

    @Override
    @Transactional
    public List<Ticket> getTickets(int page, String email) {
        User user = userRepository.findByEmail(email).orElseThrow(()-> new UserNotFoundException());
        List<Ticket> tickets = ticketRepository.findAllByUser(user,PageRequest.of(page,5,Sort.by("timestamp").descending()));
        return tickets;
    }

}
