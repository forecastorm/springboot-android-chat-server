package com.nil.server.controller;


import com.nil.server.entity.Chat;
import com.nil.server.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ChatWebSocketController {

    @Autowired
    private ChatService chatService;

    @Autowired
    public ChatWebSocketController(ChatService chatService) {
        this.chatService = chatService;
    }


    @MessageMapping("/chat/{senderIDString}/{receiverIDString}")
    @SendTo({"/topics/event/{senderIDString}/{receiverIDString}", "/topics/event/{receiverIDString}/{senderIDString}"})
    public List<Chat> getChatWithReceiverAndSender1(String content, @DestinationVariable String receiverIDString, @DestinationVariable String senderIDString) {

        int senderID = Integer.parseInt(senderIDString);
        int receiverID = Integer.parseInt(receiverIDString);

        chatService.save(new Chat(senderID, receiverID, content));
        return chatService.findBySenderOrReceiver(senderID, receiverID);

    }


    @MessageMapping("/chat/{senderIDString}/{receiverIDString}/listen")
    @SendTo("/topics/event/{senderIDString}/{receiverIDString}")
    public List<Chat> subscribeToSenderReceiverChatList(@DestinationVariable String receiverIDString, @DestinationVariable String senderIDString) {

        int senderID = Integer.parseInt(senderIDString);
        int receiverID = Integer.parseInt(receiverIDString);
        return chatService.findBySenderOrReceiver(senderID, receiverID);

    }


    @MessageMapping("/hello/{receiverIDString}")
    @SendTo("/topics/event/{receiverIDString}")
    public List<Chat> getChatWithReceiver(String content, @DestinationVariable String receiverIDString) {

        int receiverID = Integer.parseInt(receiverIDString);
        return chatService.findByReceiver(receiverID);
    }


}


