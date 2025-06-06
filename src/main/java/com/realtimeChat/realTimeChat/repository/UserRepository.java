package com.realtimeChat.realTimeChat.repository;

import com.realtimeChat.realTimeChat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
