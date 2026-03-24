package ecommerce_micro.project.orchestratorservice_ms.api.kafka.messaging.consumer;

import ecommerce_micro.project.orchestratorservice_ms.core.adapters.service.orchestrator.OrchestratorService;
import ecommerce_micro.project.avro.Event;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class SagaOrchestratorConsumer {

    private final OrchestratorService orchestratorService;

    @KafkaListener(topics = "${spring.kafka.consumer.topic.startSaga-topic}",
            groupId = "${spring.kafka.consumer.group-id}")
    public void consumeStartSagaTopic(Event event) {
        orchestratorService.delegateTopic(event);
        log.info("Received payload from saga topic start saga: {}", event);
        }

    @KafkaListener(topics = "${spring.kafka.consumer.topic.orchestrator-topic}",
            groupId = "${spring.kafka.consumer.group-id}")
    public void consumeOrchestrator(Event event) {
        orchestratorService.delegateTopic(event);
        log.info("Received payload from saga topic orchestrator: {}", event);

    }


}
