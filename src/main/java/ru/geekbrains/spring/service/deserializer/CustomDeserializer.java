package ru.geekbrains.spring.service.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.boot.jackson.JsonComponent;
import ru.geekbrains.spring.model.Product;

import java.io.IOException;

/**
 * Кастомный десериализатор JSON - Product
 */
@JsonComponent
public class CustomDeserializer extends JsonDeserializer<Product> {

    @Override
    public Product deserialize(JsonParser jsonParser,
                               DeserializationContext deserializationContext)
            throws IOException, JsonProcessingException {

        JsonNode node = jsonParser.readValueAsTree();
        if (node != null && !node.isEmpty()) {
            try {
                return new Product(
                        node.get("id").asInt(),
                        node.get("Product code").asText().split(" - ")[0],
                        node.get("cost").asInt(),
                        node.get("Product code").asText().split(" - ")[1]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
