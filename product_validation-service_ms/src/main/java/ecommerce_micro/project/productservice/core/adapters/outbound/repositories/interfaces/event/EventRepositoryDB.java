package ecommerce_micro.project.productservice.core.adapters.outbound.repositories.interfaces.event;

import ecommerce_micro.project.orderservice_ms.core.adapters.outbound.repositories.entities.event.EventEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventRepositoryDB extends MongoRepository<EventEntity, String> {

}
