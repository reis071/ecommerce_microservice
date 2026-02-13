package ecommerce_micro.project.productservice.adapters.inbound.messaging.consumer;

import ecommerce_micro.project.productservice.utils.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class ProductValidationConsumer {

    private final JsonUtil jsonUtil;

    @KafkaListener(topics = "${spring.kafka.topics.consume.product-validation-success}",
            groupId = "${spring.kafka.consumer.group-id}")
    public void consumeProductValidationSuccessTopic(String payload) {
        try {
            log.info("Received payload from product validation success topic: {}", payload);
            var eventDomain = jsonUtil.toEventDomain(payload);
            log.info("Converted message to EventDomain: {}", eventDomain);
        } catch (Exception e) {
            log.error("Error processing message from product validation success topic: {}", e.getMessage());
        }
    }

    @KafkaListener(topics = "${spring.kafka.topics.consume.product-validation-failure}",
            groupId = "${spring.kafka.consumer.group-id}")
    public void consumeProductValidationFailureTopic(String payload) {
        try {
            log.info("Received payload from product validation failure topic: {}", payload);
            var eventDomain = jsonUtil.toEventDomain(payload);
            log.info("Converted message to EventDomain: {}", eventDomain);
        } catch (Exception e) {
            log.error("Error processing message from product validation failure topic: {}", e.getMessage());
        }
    }

}
