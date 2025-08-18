package org.example.springboot2pra07.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import org.example.springboot2pra07.serializer.OrderDeserializer;
import org.example.springboot2pra07.serializer.OrderSerializer;

import java.util.Date;

@JsonSerialize(using = OrderSerializer.class) //自訂序列化可以放在類上也可以放在屬性上, 但是同時只能使用一種
@JsonDeserialize(using = OrderDeserializer.class)
public class Order_29 {
    private String orderNo;

    private double amount;

    private Date orderDate;

    //@JsonSerialize(using = StringSerializer.class) //自訂序列化可以放在類上也可以放在屬性上, 但是同時只能使用一種
    private String type;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
