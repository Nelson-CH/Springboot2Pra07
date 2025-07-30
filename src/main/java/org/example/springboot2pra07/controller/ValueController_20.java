package org.example.springboot2pra07.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URL;
import java.util.List;

/*
@PropertySource 不是「改變」 @Value 的配置來源，而是**「額外加入」**一個新的配置檔，讓 @Value 可以從中取值。
*/
@PropertySource("classpath:my.properties")
@RestController
public class ValueController_20 {
    /*
    系統默認取得 application.properties 中配置的屬性
    */
    @Value("${user.name}")
    private String name;

    /*
    取得 my.properties 中的配置屬性
    直接引用是獲取不到值的, 因為 my.properties 並沒有被 springboot 加載, 要在 class 上
    加上 @PropertySource 指定 classpath 下面的 my.properties 加載.
    */
    @Value("${user.password}")
    private String password;

    /*
    注入陣列（自動根據 "," 進行分割）
    數據來源是 application.properties 中的 tools, 注入時解析成指定的資料類型
    */
    @Value("${tools}")
    private String[] toolArray;

    /*
    注入集合形式（自動根據 "," 進行分割）
    數據來源是 application.properties 中的 tools, 注入時解析成指定的資料類型
    */
    @Value("${tools}")
    private List<String> toolList;

    /*
    注入普通字串，相當於直接給屬性預設值
    */
    @Value("程序新视界")
    private String wechatSubscription;

    /*
    注入作業系統屬性
    */
    @Value("#{systemProperties['os.name']}")
    private String systemPropertiesName;

    /*
    注入運算式結果
    */
    @Value("#{ T(java.lang.Math).random() * 100.0 }")
    private double randomNumber;

    /*
    注入其他 Bean 的屬性：注入 config 物件的屬性 tool
    */
    @Value("#{config_20.tool}")
    private String tool;

    /*
    注入列表形式（自動根據 "|" 分割）
    */
    @Value("#{'${words}'.split('\\|')}")
    private List<String> numList;

    /*
    注入檔案資源, 通過 Resource 物件進行封裝
    */
    @Value("classpath:config.xml")
    private Resource resourceFile;

    /*
    注入 URL 資源
    */
    @Value("http://www.choupangxia.com")
    private URL homePage;

    /*
    若屬性中未設定 ip，則使用預設值
    */
    @Value("${ip:127.0.0.1}")
    private String ip;

    /*
    若系統屬性中未取得 port 值，則使用 8888 為預設值
    */
    @Value("#{systemProperties['port']?:'8888'}")
    private String port;

    @GetMapping("/getvalue")
    public void getValue(){
        System.out.println("wechatSubscription=" + wechatSubscription);
        System.out.println("systemPropertiesName=" + systemPropertiesName);
        System.out.println("randomNumber=" + randomNumber);
        System.out.println("tool=" + tool);
        System.out.println("toolArray=" + toolArray[0]);
        System.out.println("toolList=" + toolList);
        System.out.println("numList=" + numList);
        System.out.println("resourceFile=" + resourceFile.getFilename());
        System.out.println("homePage=" + homePage.getHost());

        System.out.println("ip=" + ip);
        System.out.println("port=" + port);
    }
}
