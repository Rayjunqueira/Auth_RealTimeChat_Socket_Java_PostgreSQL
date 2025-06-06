package com.realtimeChat.realTimeChat.controller;


import com.realtimeChat.realTimeChat.model.Room;
import com.realtimeChat.realTimeChat.repository.RoomRepository;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    private final RoomRepository roomRepository;

    public RoomController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @PostMapping
    public Room createRoom(@RequestBody List<String> users) {
        Room room = new Room();
        room.setCode(UUID.randomUUID().toString());
        room.setUsers(users);
        return roomRepository.save(room);
    }

    @GetMapping("/{code}")
    public Room getRoom(@PathVariable String code) {
        return roomRepository.findByCode(code);
    }
}