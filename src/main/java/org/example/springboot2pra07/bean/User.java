package org.example.springboot2pra07.bean;

import org.example.springboot2pra07.annotation.InitSex;
import org.example.springboot2pra07.annotation.ValidateAge;

//測試 InitSex、ValidateAge 註解用到的類
public class User {

    private String username;

    @ValidateAge(min = 20, max = 35, value = 22)
    private int age;

    @InitSex(sex = InitSex.SEX_TYPE.MAN)
    private String sex;

    public User() {
    }

    public User(String username, int age, String sex) {
        this.username = username;
        this.age = age;
        this.sex = sex;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
