package ecommerce_micro.project.orchestratorservice_ms.core.adapters.service.orchestrator;

import ecommerce_micro.project.orchestratorservice_ms.config.kafka.settings.SagaHandler;

import ecommerce_micro.project.orchestratorservice_ms.config.kafka.settings.enums.ESagaStatus;
import ecommerce_micro.project.orchestratorservice_ms.config.kafka.settings.enums.ETopics;
import ecommerce_micro.project.orchestratorservice_ms.core.adapters.outbound.messaging.producer.sagaOrchestrator.SagaOrchestratorProducer;
import ecommerce_micro.project.avro.Event;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

import static ecommerce_micro.project.orchestratorservice_ms.config.kafka.settings.SagaHandler.*;

@RequiredArgsConstructor
@Service
public class OrchestratorService {

    private final SagaOrchestratorProducer sagaOrchestratorProducer;

    @Transactional
    public void delegateTopic(Event event){

         ETopics next_topic = Arrays.stream(SAGA_HANDLER).filter(row -> {
            String source_event = event.getSource();
            String status_event = event.getStatus();

            Object source_row = row[EVENT_SOURCE_INDEX];
            Object status_row =  row[STATUS_INDEX];

            return source_row.toString().equals(source_event) && status_row.toString().equals(status_event);})
                 .map(topic -> (ETopics)topic[TOPIC_INDEX])
                 .findFirst()
                 .orElseThrow(()-> new RuntimeException("Topic not found"));

         sagaOrchestratorProducer.sendEvent(next_topic.getTopicName(), event);
    }


}
