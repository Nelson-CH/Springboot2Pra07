package org.example.springboot2pra07.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.example.springboot2pra07.serializer.ColorDeserializer_30;
import org.example.springboot2pra07.serializer.ColorSerializer_30;
import org.example.springboot2pra07.serializer.OrderDeserializer;

@JsonSerialize(using = ColorSerializer_30.class) //@JsonSerialize 是比較穩定的作法
/*
使用場景:
資料庫中存的資料是這三種, 返回給 web 頁面的要用 css 的形式表示
*/
@JsonDeserialize(using = ColorDeserializer_30.class)
public class ColorDetail_30 {

    private double red;

    private double green;

    private double blue;


    public double getRed() {
        return red;
    }

    public void setRed(double red) {
        this.red = red;
    }

    public double getGreen() {
        return green;
    }

    public void setGreen(double green) {
        this.green = green;
    }

    public double getBlue() {
        return blue;
    }

    public void setBlue(double blue) {
        this.blue = blue;
    }

}
