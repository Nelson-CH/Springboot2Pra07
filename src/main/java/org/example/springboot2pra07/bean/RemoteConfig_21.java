package org.example.springboot2pra07.bean;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;


//@PropertySource(value = "classpath:remote.yml",factory = YamlPropertyLoaderFactory.class) //若配置文件使用的是.yml, 要用這種方式.

/*
@Validated 本身不提供驗證條件，它只是啟用 Spring Boot 的驗證功能, 真正的驗證規則是透過類似 @NotNull, @Min, @Email 這類欄位層級的註解來實現的。
要使用欄位層級驗證規則要加入
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>
*/
@Validated
/*
使用 @ConfigurationProperties 來注入配置文件屬性:
若是寫在application.properties中這樣就可以自動注入屬性了
1.創建Bean > @Component
2.@ConfigurationProperties 設定要注入的屬性名稱前綴
*/
@Component
@ConfigurationProperties(prefix = "remote")
/*
指定要讀取的配置文件, 只支持 .properties 的屬性加載, 不支持 .yml 加載要多使用 factory 屬性指定使用 yml
*/
@PropertySource({"classpath:remote.properties"})
public class RemoteConfig_21 {

    private String address;
    private int port;
    //@NotNull //添加後若屬性值不符合規則就會報錯
    private String phone;
    /*
    沒有使用 @Autowired 或其他方式把 @Bean 建立的物件注入進來，那麼即使它存在於 Spring 容器中，也不會自動被用到。
    所以這裡的 username 沒有套用到 MyConfig 的設定而是 remote.properties 的設定.
    */
    private User_21 user;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User_21 getUser() {
        return user;
    }

    public void setUser(User_21 user) {
        this.user = user;
    }
}
