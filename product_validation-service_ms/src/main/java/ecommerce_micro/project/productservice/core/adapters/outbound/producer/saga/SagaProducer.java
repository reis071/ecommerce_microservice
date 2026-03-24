package ecommerce_micro.project.productservice.core.adapters.outbound.producer.saga;

import ecommerce_micro.project.avro.Event;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class SagaProducer {

    private final KafkaTemplate<String, Event> eventKafkaTemplate;

    @Value("${spring.kafka.producer.topic.startSaga-topic}")
    private String sagaTopic;

    public void sendEvent(Event event) {
        try {
            log.info("Sending Avro event to saga topic: {} | Transaction ID: {}", sagaTopic, event.getTransactionId());
            eventKafkaTemplate.send(sagaTopic, event.getTransactionId().toString(), event);
            log.info("Avro event sent successfully");
        } catch (Exception e) {
            log.error("Error sending Avro event to saga topic: {}", e.getMessage(), e);
            throw new RuntimeException("Failed to send Avro event", e);
        }
    }

}
