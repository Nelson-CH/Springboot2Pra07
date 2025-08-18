package org.example.springboot2pra07.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import org.example.springboot2pra07.entity.Order_29;

import java.io.IOException;

public class OrderDeserializer extends JsonDeserializer<Order_29> {

    @Override
    public Order_29 deserialize(JsonParser parser, DeserializationContext ctxt) throws IOException {
        JsonNode node = parser.getCodec().readTree(parser);
        String userName = node.get("orderNo").asText();
        Order_29 order = new Order_29();
        order.setOrderNo(userName);
        order.setAmount(node.get("amount").asDouble());
        return order;
    }

}
