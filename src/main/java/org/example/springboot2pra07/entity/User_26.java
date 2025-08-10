package org.example.springboot2pra07.entity;

import java.util.Date;

public class User_26 {

    private String userNo;
    private String username;
    private int age;
    private Date createDate;

    public User_26() {
    }

    public User_26(String userNo, String username, int age, Date createDate) {
        this.userNo = userNo;
        this.username = username;
        this.age = age;
        this.createDate = createDate;
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
