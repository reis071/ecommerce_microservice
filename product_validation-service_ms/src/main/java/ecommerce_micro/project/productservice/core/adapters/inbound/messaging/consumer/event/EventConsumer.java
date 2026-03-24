package ecommerce_micro.project.orderservice_ms.core.adapters.inbound.messaging.consumer.event;

import ecommerce_micro.project.avro.Event;
import ecommerce_micro.project.orderservice_ms.core.adapters.outbound.mapper.event.EventMapper;
import ecommerce_micro.project.orderservice_ms.core.adapters.outbound.repositories.impl.event.EventImpl;
import ecommerce_micro.project.orderservice_ms.core.domain.entities.event.EventDomain;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventConsumer {

    private static final Logger log = LoggerFactory.getLogger(EventConsumer.class);
    private final EventImpl eventImpl;
    private final EventMapper eventMapper;

    @KafkaListener(
            topics = "${spring.kafka.consumer.topic.notifyEnd-topic}",
            groupId = "${spring.kafka.consumer.group-id}",
            containerFactory = "eventKafkaListenerContainerFactory"
    )

    public void consumeEvent(ConsumerRecord<String, Event> record, Acknowledgment acknowledgment) {
        try {
            Event event = record.value();

            log.info("Received Avro event from notify-end | Transaction ID: {} | Status: {}",
                    event.getTransactionId(), event.getStatus());

            processEvent(event);

            acknowledgment.acknowledge();
            log.info("Avro event processed successfully");
        } catch (Exception e) {
            log.error("Error processing Avro event: {}", e.getMessage(), e);
        }
    }

    private void processEvent(Event event) {
        log.info("Processing event | Order ID: {} | Status: {}",
                event.getOrderId(), event.getStatus());
        EventDomain eventDomain =  eventMapper.toDomain(event);

        eventImpl.save(eventDomain);
    }
}