package org.example.springboot2pra07.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.example.springboot2pra07.entity.Order_29;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

//自訂序列化器 (Custom Serializer)，讓 Jackson 在把 Order_29 物件轉成 JSON 時依照定義的規則來輸出。
public class OrderSerializer extends JsonSerializer<Order_29> {
    @Override
    public void serialize(Order_29 value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject(); //開始寫一個 JSON 物件（即 {）。
        //要自己寫的設定
        gen.writeStringField("order-no", value.getOrderNo()); //輸出Json key "order-no"，值來自 Order_29.getOrderNo()
        gen.writeNumberField("amount",value.getAmount());     //輸出Json key "amount"，值來自 Order_29.getAmount()。
        gen.writeStringField("date",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())); //輸出Json key "date"，值是「現在時間」並格式化成 yyyy-MM-dd HH:mm:ss。

        gen.writeEndObject(); //結束 JSON 物件（即 }）。

    }
}
