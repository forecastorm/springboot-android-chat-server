package com.nil.server.service;


import com.nil.server.entity.Chat;

import java.util.List;

public interface ChatService {

    List<Chat> findAll();

    List<Chat> findBySenderOrReceiver(int senderID, int receiverID);

    List<Chat> findByReceiver(int receiverID);

    void save(Chat theChat);

}