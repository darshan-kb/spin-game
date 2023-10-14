package com.spin.game.repository;

import com.spin.game.entities.Ticket;
import com.spin.game.entities.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket,Long> {

    List<Ticket> findAllByUser(User user, Pageable page);
    long countByUser(User user);
}
