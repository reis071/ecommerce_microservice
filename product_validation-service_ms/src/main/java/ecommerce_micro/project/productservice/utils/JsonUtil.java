package ecommerce_micro.project.productservice.utils;


import ecommerce_micro.project.productservice.adapters.inbound.dtosResponse.event.EventDomain;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Component
@AllArgsConstructor
public class JsonUtil {

    private final ObjectMapper objectMapper;

    public String toJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException("Error converting object to JSON", e);
        }
    }

    public EventDomain toEventDomain(String json) {
        try {
            return objectMapper.readValue(json, EventDomain.class);
        } catch (Exception e) {
            throw new RuntimeException("Error converting JSON to EventDomain", e);
        }
    }

}
