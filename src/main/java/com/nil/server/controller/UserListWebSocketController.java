package com.nil.server.controller;

import com.nil.server.entity.User;
import com.nil.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserListWebSocketController {

    @Autowired
    private UserService userService;

    @Autowired
    public UserListWebSocketController(UserService userService) {
        this.userService = userService;
    }

    @MessageMapping("/userList/status/on")
    @SendTo("/topics/userList")
    public List<User> turnOnUserStatus(String idString) {

        int id = Integer.parseInt(idString);

        User user = userService.findById(id);
        user.setStatus(0);
        userService.save(user);

        return userService.findAll();

    }

    @MessageMapping("/userList/status/off")
    @SendTo("/topics/userList")
    public List<User> turnOffUserStatus(String idString) {

        int id = Integer.parseInt(idString);

        User user = userService.findById(id);
        user.setStatus(-1);
        userService.save(user);
        return userService.findAll();
    }


    @MessageMapping("/userList/status/listen")
    @SendTo("/topics/userList")
    public List<User> subscribeToUserList() {

        return userService.findAll();
    }

}
