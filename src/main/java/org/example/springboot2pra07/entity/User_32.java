package org.example.springboot2pra07.entity;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Data
@Log4j2
public class User_32 {

    private int id;
    private String num;
    private String remark;

    public void printLog(){
        log.info("id:"+id+",num:"+num+",remark:"+remark);
    }
}
