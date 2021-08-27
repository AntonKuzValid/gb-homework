package ru.geekbrains.spring.service.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.jackson.JsonComponent;
import ru.geekbrains.spring.model.Product;

import java.io.IOException;

/**
 * Кастомный десериализатор JSON - Product
 */
@JsonComponent
@Log4j2
public class CustomDeserializer extends JsonDeserializer<Product> {

    @Override
    public Product deserialize(JsonParser jsonParser,
                               DeserializationContext deserializationContext)
            throws IOException, JsonProcessingException {
        return
            buildProduct(jsonParser.readValueAsTree());
    }

    private Product buildProduct(JsonNode node) {
        if (node != null && !node.isEmpty()) {
            Product p = new Product();
            try {
                p.setTitle(node.get("Product code").asText().split(" - ")[0]);
                p.setCost(node.get("cost").asInt());
                p.setCompany(node.get("Product code").asText().split(" - ")[1]);
                log.debug("Deserialization success " + p);
                return p;
            } catch (NullPointerException | IndexOutOfBoundsException e) {
                log.debug(e.getMessage() + " " + e.getCause());
                return null;
            } finally {
                p = null;
            }
        } else {
            return null;
        }
    }
}
