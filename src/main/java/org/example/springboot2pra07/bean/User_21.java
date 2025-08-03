package org.example.springboot2pra07.bean;

import org.example.springboot2pra07.annotation.InitSex;
import org.example.springboot2pra07.annotation.ValidateAge;
import org.springframework.stereotype.Component;

/*
如果使用 @Resource（或 @Autowired）注入 User_21 類別的實例，那 User_21 必須是 Spring 容器能夠管理的 Bean，否則會報錯找不到對應的 Bean
所以要加上 @Component
*/
@Component
public class User_21 {

    private String username;
    private String password;
    private String firstName;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
