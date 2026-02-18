package ecommerce_micro.project.orderservice_ms.core.application.service.order;

import ecommerce_micro.project.orderservice_ms.adapters.outbound.avro.EventAvro;
import ecommerce_micro.project.orderservice_ms.config.mskafka.settings.enums.EEventSource;
import ecommerce_micro.project.orderservice_ms.config.mskafka.settings.enums.ESagaStatus;
import ecommerce_micro.project.orderservice_ms.core.adapters.outbound.mapper.event.EventMapper;
import ecommerce_micro.project.orderservice_ms.core.adapters.outbound.producer.saga.SagaProducer;
import ecommerce_micro.project.orderservice_ms.core.adapters.outbound.repositories.impl.event.EventImpl;
import ecommerce_micro.project.orderservice_ms.core.adapters.outbound.repositories.impl.order.OrderImpl;
import ecommerce_micro.project.orderservice_ms.core.application.dtoRequest.order.OrderDTORequest;

import ecommerce_micro.project.orderservice_ms.core.application.usecases.order.OrderUseCases;
import ecommerce_micro.project.orderservice_ms.core.domain.entities.event.EventDomain;
import ecommerce_micro.project.orderservice_ms.core.domain.entities.order.OrderDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class OrderService implements OrderUseCases {
    private final OrderImpl orderImpl;
    private final EventImpl eventImpl;
    private final EventMapper eventMapper;
    private final SagaProducer sagaProducer;

    @Override
    public OrderDomain registerOrder(OrderDTORequest orderDTORequest) {
        OrderDomain order = new OrderDomain();

        order.setTransactionId(idGenerator());
        order.setProducts(orderDTORequest.products());
        order.setCreatedAt(LocalDateTime.now());

        OrderDomain savedOrder = orderImpl.save(order);

        eventRegisterOrder(savedOrder);

        return savedOrder;

    }
    private String idGenerator() {
        return String.format("%s_%s", Instant.now().toEpochMilli(), UUID.randomUUID());
    }

    @Override
    public void eventRegisterOrder(OrderDomain order) {
        EventDomain eventDomain = new EventDomain();

        eventDomain.setCreatedAt(LocalDateTime.now());
        eventDomain.setOrderId(order.getId());
        eventDomain.setTransactionId(idGenerator());
        eventDomain.setPayload(order);
        eventDomain.setSource(EEventSource.ORDER_SERVICE.name());
        eventDomain.setStatus(ESagaStatus.SUCCESS.name());


       EventDomain savedEvent = eventImpl.save(eventDomain);

        EventAvro eventAvro = eventMapper.toAvro(savedEvent);

        sagaProducer.sendEvent(eventAvro);



    }
}
