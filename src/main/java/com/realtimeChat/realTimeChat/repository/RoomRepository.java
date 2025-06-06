package com.realtimeChat.realTimeChat.repository;


import com.realtimeChat.realTimeChat.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
    Room findByCode(String code);
}