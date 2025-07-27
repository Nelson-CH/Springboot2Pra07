package org.example.springboot2pra07;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

//把資料庫的自動配置先排除掉
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Springboot2Pra07Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot2Pra07Application.class, args);
    }

}
