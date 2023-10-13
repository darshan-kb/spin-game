package com.spin.game.repository;

import com.spin.game.entities.Bet;
import com.spin.game.entities.ClaimBet;
import com.spin.game.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClaimBetRepository extends JpaRepository<ClaimBet,Long> {

    Optional<List<ClaimBet>> findAllByUser(User user);
    Optional<ClaimBet> findByBet(Bet bet);
}
