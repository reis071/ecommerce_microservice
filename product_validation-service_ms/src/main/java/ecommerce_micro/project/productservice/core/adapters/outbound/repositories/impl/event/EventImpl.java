package ecommerce_micro.project.orderservice_ms.core.adapters.outbound.repositories.impl.event;

import ecommerce_micro.project.orderservice_ms.core.adapters.outbound.mapper.event.EventMapper;
import ecommerce_micro.project.orderservice_ms.core.adapters.outbound.repositories.entities.event.EventEntity;
import ecommerce_micro.project.orderservice_ms.core.adapters.outbound.repositories.interfaces.event.EventRepositoryDB;
import ecommerce_micro.project.orderservice_ms.core.domain.entities.event.EventDomain;
import ecommerce_micro.project.orderservice_ms.core.domain.repository.event.EventRepositoryDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class EventImpl implements EventRepositoryDomain {

    private final EventMapper eventMapper;
    private final EventRepositoryDB eventRepositoryDB;

    @Override
    public EventDomain save(EventDomain event) {

        EventEntity eventEntity = eventMapper.toEntity(event);
        EventEntity savedEventEntity = eventRepositoryDB.save(eventEntity);
        return eventMapper.toDomain(savedEventEntity);
    }

}
