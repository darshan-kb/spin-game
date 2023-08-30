package com.spin.game.repository;

import com.spin.game.entities.BetValuesMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BetValuesMapRepository extends JpaRepository<BetValuesMap,Long> {

    @Query("SELECT b.betValues FROM BetValuesMap b WHERE b.betName = :betName AND b.betIndex = :index")
    public Optional<String> getElements(@Param("betName") String betName, @Param("index") int index);
}
