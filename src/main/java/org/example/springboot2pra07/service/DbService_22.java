package org.example.springboot2pra07.service;


import jakarta.annotation.Resource;
import org.example.springboot2pra07.db.DbConfigBean_22;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DbService_22 {

    @Autowired
    private DbConfigBean_22 configBean;

    public void getDbInfo(){
        configBean.printInfo();
    }
}
