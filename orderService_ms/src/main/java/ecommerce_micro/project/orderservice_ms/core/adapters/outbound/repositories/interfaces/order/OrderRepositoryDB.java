package ecommerce_micro.project.orderservice_ms.core.adapters.outbound.repositories.interfaces.order;

import ecommerce_micro.project.orderservice_ms.core.adapters.outbound.repositories.entities.order.OrderEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepositoryDB extends MongoRepository<OrderEntity, String> {
}
