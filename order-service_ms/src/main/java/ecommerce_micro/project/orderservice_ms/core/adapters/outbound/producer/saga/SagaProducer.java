package ecommerce_micro.project.orderservice_ms.core.adapters.outbound.producer.saga;

import ecommerce_micro.project.orderservice_ms.adapters.outbound.avro.EventAvro;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class SagaProducer {

    private final KafkaTemplate<String, EventAvro> eventAvroKafkaTemplate;

    @Value("${spring.kafka.producer.topic.start-saga}")
    private String sagaTopic;

    public void sendEvent(EventAvro eventAvro) {
        try {
            log.info("Sending Avro event to saga topic: {} | Transaction ID: {}", sagaTopic, eventAvro.getTransactionId());
            eventAvroKafkaTemplate.send(sagaTopic, eventAvro.getTransactionId().toString(), eventAvro);
            log.info("Avro event sent successfully");
        } catch (Exception e) {
            log.error("Error sending Avro event to saga topic: {}", e.getMessage(), e);
            throw new RuntimeException("Failed to send Avro event", e);
        }
    }

}
