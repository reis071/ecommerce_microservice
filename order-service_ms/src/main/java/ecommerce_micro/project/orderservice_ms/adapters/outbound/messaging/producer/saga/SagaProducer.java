package ecommerce_micro.project.orderservice_ms.adapters.outbound.messaging.producer.saga;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class SagaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${spring.kafka.topic.start-saga}")
    private String sagaTopic;

    public void sendEvent(String payload) {
        try {
        log.info("Sending message to saga topic: {}", sagaTopic);
        kafkaTemplate.send(sagaTopic, payload);
        }catch (Exception e){
            log.error("Error sending message to saga topic: {}", e.getMessage());
        }
    }

}
