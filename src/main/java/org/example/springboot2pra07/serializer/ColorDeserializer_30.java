package org.example.springboot2pra07.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.node.TextNode;
import org.example.springboot2pra07.entity.ColorDetail_30;

import java.awt.*;
import java.io.IOException;

public class ColorDeserializer_30 extends JsonDeserializer<ColorDetail_30> {

    @Override
    public ColorDetail_30 deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        TreeNode treeNode = p.getCodec().readTree(p);
        TextNode webColor = (TextNode) treeNode.get("webColor");

        Color color = Color.decode(webColor.asText());

        ColorDetail_30 detail = new ColorDetail_30();
        detail.setRed(color.getRed());
        detail.setGreen(color.getGreen());
        detail.setBlue(color.getBlue());

        return detail;
    }

}
