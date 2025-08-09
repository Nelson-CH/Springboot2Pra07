package org.example.springboot2pra07.db;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public class MysqlDbConfigBean_22 implements DbConfigBean_22{
    @Override
    public void printInfo() {
        System.out.println("I am Mysql");
    }
}
