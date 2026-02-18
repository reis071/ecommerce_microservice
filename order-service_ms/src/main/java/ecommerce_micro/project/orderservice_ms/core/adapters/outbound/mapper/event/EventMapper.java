package ecommerce_micro.project.orderservice_ms.core.adapters.outbound.mapper.event;

import ecommerce_micro.project.orderservice_ms.adapters.outbound.avro.EventAvro;
import ecommerce_micro.project.orderservice_ms.core.adapters.outbound.mapper.order.OrderMapper;
import ecommerce_micro.project.orderservice_ms.core.adapters.outbound.repositories.entities.event.EventEntity;
import ecommerce_micro.project.orderservice_ms.core.domain.entities.event.EventDomain;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {OrderMapper.class})
public interface EventMapper {

    EventEntity toEntity(EventDomain eventDomain);
    EventAvro toAvro(EventDomain eventDomain);

    EventDomain toDomain(EventEntity eventEntity);
    EventDomain toDomain(EventAvro eventAvro);


}
