package ecommerce_micro.project.orchestratorservice_ms.core.adapters.outbound.messaging.producer.sagaOrchestrator;


import ecommerce_micro.project.avro.Event;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class SagaOrchestratorProducer {

        private final KafkaTemplate<String, Event> kafkaTemplate;

        public void sendEvent(String topic, Event event) {
            try {
                log.info("Sending message to saga topic: {}", topic);
                kafkaTemplate.send(topic, event);
            } catch (Exception e) {
                log.error("Error sending message to saga topic: {}", e.getMessage());
            }
        }
}
