package org.example.springboot2pra07.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.example.springboot2pra07.View.View_28;
import org.example.springboot2pra07.entity.LoginUser_28;
import org.example.springboot2pra07.entity.UserDetail_28;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class JsonAnnotationController_28 {

    @GetMapping("/userInfo28")
    public LoginUser_28 getUserInfo() {
        LoginUser_28 user = new LoginUser_28();
        user.setUsername("15600000000");
        user.setPassword("123456");
        user.setLoginTime(new Date());

        return user;
    }

    //返回BaseView指定的欄位
    @JsonView(View_28.BaseView.class)
    @GetMapping("/getUserViewInfo28")
    public UserDetail_28 getUserViewInfo() {
        //即使這裡都又賦值好所有屬性但是透過@JsonView過濾後, 只會回傳指定的屬性
        UserDetail_28 user = new UserDetail_28();
        user.setUserNo("10000");
        user.setUsername("Tom");
        user.setAddress("Beijing");
        user.setEmail("124@qq.com");
        return user;
    }

    //返回DetailView指定的欄位
    @JsonView(View_28.DetailView.class)
    @GetMapping("/getUserDetailViewInfo28")
    public UserDetail_28 getUserDetailViewInfo() {
        //即使這裡都又賦值好所有屬性但是透過@JsonView過濾後, 只會回傳指定的屬性
        UserDetail_28 user = new UserDetail_28();
        user.setUserNo("10000");
        user.setUsername("Tom");
        user.setAddress("Beijing");
        user.setEmail("124@qq.com");
        return user;
    }

}
