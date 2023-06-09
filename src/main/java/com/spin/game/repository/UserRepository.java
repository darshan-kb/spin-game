package com.spin.game.repository;

import com.spin.game.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.enabled=TRUE WHERE u.email=?1")
    int enableUser(String email);
}
