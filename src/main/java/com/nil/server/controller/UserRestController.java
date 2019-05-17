package com.nil.server.controller;

import com.nil.server.entity.User;
import com.nil.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @Autowired
    private UserService userService;

    @Autowired
    public UserRestController(UserService theUserService) {
        userService = theUserService;
    }

    @GetMapping("/users")
    public List<User> findAll() {
        return userService.findAll();
    }


    // mapping for adding a user, post method
    @PostMapping("/users/post")
    public User addUser(@RequestBody User theUser) {

        //before adding a user, check if username already exist
        if (userService.findByUserName(theUser.getUserName()) != null) {
            return User.USER_NAME_TAKEN;
        } else {
            theUser.setId(0);
            userService.save(theUser);
            return theUser;
        }

    }

    // mapping for delete user with id

    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable int userId) {

        User tempUser = userService.findById(userId);

        if (tempUser == null) {

            throw new RuntimeException(("The item to be deleted not found - " + userId));
        }
        userService.deleteById(userId);

        return "Deleted user id - " + userId;
    }


    // mapping for put, update existing user

    @PutMapping("/users")
    public User updateUser(@RequestBody User theUser) {

        userService.save(theUser);
        return theUser;
    }

}
