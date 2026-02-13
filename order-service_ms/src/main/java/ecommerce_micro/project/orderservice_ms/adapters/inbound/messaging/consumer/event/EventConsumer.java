package ecommerce_micro.project.orderservice_ms.adapters.inbound.messaging.consumer.event;

import ecommerce_micro.project.orderservice_ms.utils.JsonUtil;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class EventConsumer {

    private static final Logger log = LoggerFactory.getLogger(EventConsumer.class);
    private final JsonUtil jsonUtil;

    @KafkaListener(topics = "${spring.kafka.topic.notify-end}",
            groupId = "${spring.kafka.consumer.group-id}")
    public void consumeEvent(String payload) {
        try {
            log.info("Received payload from topic notify end: {}", payload);
            var eventDomain = jsonUtil.toEventDomain(payload);
            log.info("Converted message to EventDomain: {}", eventDomain);
        } catch (Exception e) {
            log.error("Error processing message: {}", e.getMessage());
        }
    }
}
