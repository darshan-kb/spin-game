package com.spin.game.repository;

import com.spin.game.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepo extends JpaRepository<Game, Long> {
}
