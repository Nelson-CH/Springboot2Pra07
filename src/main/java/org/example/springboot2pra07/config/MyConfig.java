package org.example.springboot2pra07.config;

import org.example.springboot2pra07.bean.User_21;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
@Configuration:
表示這是一個 Spring 設定類別，可以用來定義 @Bean 方法（相當於 XML 中的 <bean> 定義）。
*/
/*
跟 RemoteConfig_21 直接將設定要綁定的配置文件屬性前綴寫在類上不同, 這裡是通過另外寫一個設定類,
這樣的方式可以處理以下情境:
1.類不是自己寫的:
類來自某個第三方或團隊同仁打包好的 .jar 檔案中的類別, 這種類別不能加上 @Component、@ConfigurationProperties 等註解，
因為你不能也不應去改動它的原始碼。
例如，有個共用模組或框架叫「common-utils.jar」，裡面定義了：
public class User_21 {
    private String name;
    private int age;
}
用maven引入後用這樣的寫法管理.

2.可另外控制 Bean 邏輯
比如依條件產生不同實例
@Bean
public User_21 user() {
    if (someCondition) {
        return new User_21("A");
    } else {
        return new User_21("B");
    }
}
*/
@Configuration
public class MyConfig {

    @Bean //產生一個 Spring 管理的 Bean
    @ConfigurationProperties(prefix = "user") //找配置檔中以 user. 開頭的屬性，然後將它們對應到 User_21 類別的欄位上。
    public User_21 user(){
        return new User_21();
    }

}
