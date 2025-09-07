package org.example.springboot2pra07.controller;

import org.example.springboot2pra07.entity.User_34;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController_34 {

    @GetMapping("/userInfo34")
    public User_34 getUserInfo34() {
        User_34 user = new User_34();
        user.setUserId(1);
        user.setUserName("Tom");

        return user;
    }
}
