package ecommerce_micro.project.productservice.core.domain.repository.event;

import ecommerce_micro.project.orderservice_ms.core.domain.entities.event.EventDomain;

public interface EventRepositoryDomain {
    EventDomain save(EventDomain event);
}
