package com.spin.game.repository;

import com.spin.game.entities.Game;
import com.spin.game.model.projection.GameResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

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

    @Query("SELECT g FROM Game g WHERE g.isGameOver=true ORDER BY g.gameTimeStamp DESC LIMIT 5")
    List<GameResult> fetchTop5GameOverRow();
}
