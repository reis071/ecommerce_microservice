package ecommerce_micro.project.productservice.adapters.outbound.messaging.producer.orchestrator;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrchestratorProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${spring.kafka.topic.producer.orchestrator}")
    private String orchestratorTopic;

    public void sendEvent(String payload) {
        try {
        log.info("Sending message to saga topic: {}", orchestratorTopic);
        kafkaTemplate.send(orchestratorTopic, payload);
        }catch (Exception e){
            log.error("Error sending message to saga topic: {}", e.getMessage());
        }
    }

}
