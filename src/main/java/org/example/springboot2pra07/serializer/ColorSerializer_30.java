package org.example.springboot2pra07.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.example.springboot2pra07.entity.ColorDetail_30;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

//@JsonComponent 沒有自動套用, 要用 ObjectMapper 輔助, @JsonSerialize 比較穩定
public class ColorSerializer_30 extends JsonSerializer<ColorDetail_30> {

    @Override
    public void serialize(ColorDetail_30 colorDetail, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("webColor", getColorAsWebColor(colorDetail));
        gen.writeEndObject();
    }

    private static String getColorAsWebColor(ColorDetail_30 colorDetail) {
        int r = (int) Math.round(colorDetail.getRed() * 255.0);
        int g = (int) Math.round(colorDetail.getGreen() * 255.0);
        int b = (int) Math.round(colorDetail.getBlue() * 255.0);
        return String.format("#%02x%02x%02x", r, g, b);
    }

}
