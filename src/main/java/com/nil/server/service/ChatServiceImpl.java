package com.nil.server.service;

import com.nil.server.dao.ChatRepository;
import com.nil.server.entity.Chat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {


    @Autowired
    private ChatRepository chatRepository;

    @Override
    public List<Chat> findAll() {
        return chatRepository.findAll();
    }


    @Override
    public void save(Chat theChat) {
        chatRepository.save(theChat);
    }

    @Override
    public List<Chat> findBySenderOrReceiver(int senderID, int receiverID) {

        List<Chat> allChats = chatRepository.findAll();

        List<Chat> result = new ArrayList<>();

        for (Chat chat : allChats) {

            if ((chat.getSender() == senderID || chat.getReceiver() == senderID) && (chat.getReceiver() == receiverID || chat.getSender() == receiverID)) {
                result.add(chat);
            }
        }

        return result;
    }

    @Override
    public List<Chat> findByReceiver(int receiverID) {

        List<Chat> allChats = chatRepository.findAll();

        List<Chat> result = new ArrayList<>();

        for (Chat chat : allChats) {

            if (chat.getSender() == receiverID || chat.getReceiver() == receiverID) {
                result.add(chat);
            }
        }
        return result;

    }
}
