package com.spin.game.repository;

import com.spin.game.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface GameRepo extends JpaRepository<Game, Long> {

    @Query("""
            SELECT g FROM Game g
            WHERE
            g.gameTimeStamp = (SELECT MAX(g1.gameTimeStamp) FROM Game g1)
            """)
    Game findLatestGame();

    @Query(
            """
                    SELECT g FROM Game g
                    ORDER BY
                    g.gameTimeStamp
                    DESC
                    LIMIT 10
                    """
    )
    List<Game> findLastTenGame();
}
