package org.example.springboot2pra07.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.example.springboot2pra07.View.View_28;

//將屬性是駝峰命名的改成底線式
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserDetail_28 {

    //搭配一個 View 類別（介面或 class），來指定哪些欄位要輸出。
    @JsonView(View_28.BaseView.class)
    private String userNo;

    @JsonView(View_28.BaseView.class)
    private String username;

    @JsonView(View_28.DetailView.class)
    private String address;

    @JsonView(View_28.DetailView.class)
    private String email;


    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
