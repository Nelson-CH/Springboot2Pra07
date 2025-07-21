package org.example.springboot2pra07.controller;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
//單元測試
public class HelloWorldTest {

    //常用於工具類測試
    /*
    @Test
    public void testPrint() {
        System.out.println("Hello World");
    }
    */

    //spring-boot-starter-test 預設引入的 Mockmvc, 通常用預測試 Controller 層, 針對 RESTful API
    private MockMvc mockMvc;

    @Autowired
    private HelloWorldController_08 controller;

    /*
    @BeforeEach:
    來源：JUnit 5 (Jupiter) 註解
    用途：在每個 @Test 方法執行前都會執行這個方法
    時機：每次測試前的初始化工作
    對比：JUnit 4 使用 @Before
    */
    @BeforeEach
    public void setup(){
        //standaloneSetup() 接收的參數是要測試的 Controller
        /*
        MockMvcBuilders.standaloneSetup():
        用途：建立獨立的 MockMvc 實例
        特點：
        - 只載入指定的 Controller
        - 不載入完整的 Spring MVC 配置
        - 輕量級，啟動快速
        - 適合單純測試 Controller 邏輯
        */
        /*
        詳細流程：
        1.MockMvcBuilders.standaloneSetup(controller)
            - 返回 StandaloneMockMvcBuilder 物件這時還沒有真正建立 MockMvc

        2..build()
            - 真正建立並返回 MockMvc 實例, 把所有配置組裝成可用的物件
        */
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testHelloWorld() throws Exception {
        /*
        mockMvc.perform()
        用途：執行 HTTP 請求模擬
        返回：ResultActions 物件，可以鏈式調用驗證方法
        */
        /*
        MockMvcRequestBuilders.get()
        用途：建立 GET 請求
        其他方法：
        - post() - POST 請求
        - put() - PUT 請求
        - delete() - DELETE 請求
        - patch() - PATCH 請求
        */
        /*
        .andDo(print())
        作用：在控制台印出請求和響應的詳細資訊
        */
        /*
        .andExpect(status().isOk())
        作用：驗證 HTTP 響應狀態碼 status().isOk() = 驗證狀態碼是 200
        */
        /*
        .andExpect(content().string(equalTo("Hello World!")))
        作用：驗證響應內容
        content().string() = 驗證響應體的字串內容
        equalTo("Hello World!") = Hamcrest 匹配器，檢查是否完全相等
        */
        mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(equalTo("Hello World!")));
    }

}
