package com.realtimeChat.realTimeChat.controller;

import com.realtimeChat.realTimeChat.model.ChatMessage;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    private final SimpMessagingTemplate messagingTemplate;

    public ChatController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/chat/{roomId}")
    public void sendMessage(@DestinationVariable String roomId, ChatMessage message) {
        message.setTimestamp(java.time.LocalDateTime.now().toString());
        messagingTemplate.convertAndSend("/topic/room/" + roomId, message);
    }
}
