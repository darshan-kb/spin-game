package com.spin.game.repository;

import com.spin.game.entities.BetCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BetCategoryRepository extends JpaRepository<BetCategory,Integer> {
}
