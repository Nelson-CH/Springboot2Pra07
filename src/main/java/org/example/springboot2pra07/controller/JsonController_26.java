package org.example.springboot2pra07.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.springboot2pra07.entity.User_26;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class JsonController_26 {
    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/userInfo26")
    public User_26 getUserInfo() {
        User_26 user = new User_26();
        user.setUserNo("1000");
        user.setUsername("Tom");
        user.setAge(18);
        user.setCreateDate(new Date());

        return user;
    }

    @PostMapping("/addUser")
    public void addUser(@RequestBody User_26 user) {

        System.out.println("userNo: " + user.getUserNo());
        System.out.println("username: " + user.getUsername());
        System.out.println("age: " + user.getAge());
        System.out.println("createDate: " + user.getCreateDate());
    }

    @GetMapping("/writeString")
    public String writeString() throws JsonProcessingException {
        User_26 user = new User_26();
        user.setUserNo("1000");
        user.setUsername("Tom");
        user.setAge(18);
        user.setCreateDate(new Date());

        return objectMapper.writeValueAsString(user);
    }

    @PostMapping("/readJson26")
    public void readJson(@RequestBody String userJson) throws JsonProcessingException {

        User_26 user = objectMapper.readValue(userJson,User_26.class);
        System.out.println("userNo: " + user.getUserNo());
        System.out.println("username: " + user.getUsername());
        System.out.println("age: " + user.getAge());
        System.out.println("createDate: " + user.getCreateDate());

        System.out.println("----------------------");

        JsonNode jsonNode = objectMapper.readTree(userJson);
        JsonNode userNo = jsonNode.get("userNo");
        System.out.println("userNo(get from jsonNode):" + userNo.textValue());

    }
}
