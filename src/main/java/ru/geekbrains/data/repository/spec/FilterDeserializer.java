package ru.geekbrains.data.repository.spec;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.util.Locale;

@JsonComponent
@Slf4j
public class FilterDeserializer extends JsonDeserializer<Filter> {

    @Override
    public Filter deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        return buildFilter(jsonParser.readValueAsTree());
    }

    private Filter buildFilter(JsonNode node) {
        if (node != null && !node.isEmpty()) {
            Filter f = new Filter();
            try {
                f.setMax(node.get("max").asInt());
                f.setMin(node.get("min").asInt());
                f.setC(Command.valueOf(node.get("c").asText().toUpperCase(Locale.ROOT)));
                return f;
            } catch (NullPointerException e) {
                log.info(e.getMessage());
                return null;
            }
        } else {
            return null;
        }
    }
}
