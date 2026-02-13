package ecommerce_micro.project.orchestratorservice_ms.adapters.outbound.messaging.producer.sagaOrchestrator;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class SagaOrchestratorProducer {

        private final KafkaTemplate<String, String> kafkaTemplate;

        public void sendEvent(String topic, String payload) {
            try {
                log.info("Sending message to saga topic: {}", topic);
                kafkaTemplate.send(topic, payload);
            } catch (Exception e) {
                log.error("Error sending message to saga topic: {}", e.getMessage());
            }
        }
}
