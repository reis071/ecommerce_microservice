package ecommerce_micro.project.orchestratorservice_ms.adapters.inbound.messaging.consumer;

import ecommerce_micro.project.orchestratorservice_ms.utils.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class SagaOrchestratorConsumer {

    private final JsonUtil jsonUtil;

    @KafkaListener(topics = "${spring.kafka.topics.consume.start-saga}",
            groupId = "${spring.kafka.consumer.group-id}")
    public void consumeStartSagaTopic(String payload) {

        log.info("Received payload from saga topic: {}", payload);
        var event = jsonUtil.toEventDomain(payload);
        log.info("Converted message to EventDomain: {}", event);
    }

    @KafkaListener(topics = "${spring.kafka.topics.consume.orchestrator}",
            groupId = "${spring.kafka.consumer.group-id}")
    public void consumeOrchestratorTopic(String payload) {
        log.info("Received payload from orchestrator topic: {}", payload);
        var event = jsonUtil.toEventDomain(payload);
        log.info("Converted message to EventDomain: {}", event);
    }

    @KafkaListener(topics = "${spring.kafka.topics.consume.final-success}",
            groupId = "${spring.kafka.consumer.group-id}")
    public void consumeFinalSuccessTopic(String payload) {
        log.info("Received payload from final success topic: {}", payload);
        var event = jsonUtil.toEventDomain(payload);
        log.info("Converted message to EventDomain: {}", event);
    }

    @KafkaListener(topics = "${spring.kafka.topics.consume.final-fail}",
            groupId = "${spring.kafka.consumer.group-id}")
     public void consumeFinalFailTopic(String payload) {
        log.info("Received payload from final failure topic: {}", payload);
        var event = jsonUtil.toEventDomain(payload);
        log.info("Converted message to EventDomain: {}", event);
    }
}
