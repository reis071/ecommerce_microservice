package ecommerce_micro.project.productservice.core.domain.repository.order;

import ecommerce_micro.project.orderservice_ms.core.domain.entities.order.OrderDomain;

public interface OrderRepositoryDomain {

    OrderDomain save(OrderDomain order);
}
