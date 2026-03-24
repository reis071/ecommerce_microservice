package ecommerce_micro.project.orderservice_ms.core.adapters.outbound.repositories.impl.order;

import ecommerce_micro.project.orderservice_ms.core.adapters.outbound.mapper.order.OrderMapper;
import ecommerce_micro.project.orderservice_ms.core.adapters.outbound.repositories.entities.order.OrderEntity;
import ecommerce_micro.project.orderservice_ms.core.adapters.outbound.repositories.interfaces.order.OrderRepositoryDB;
import ecommerce_micro.project.orderservice_ms.core.domain.entities.order.OrderDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderImpl {

    private final OrderMapper orderMapper;
    private final OrderRepositoryDB orderRepositoryDB;

    public OrderDomain save(OrderDomain orderDomain) {
        OrderEntity orderEntity = orderMapper.toEntity(orderDomain);
        OrderEntity savedOrderEntity = orderRepositoryDB.save(orderEntity);
        return orderMapper.toDomain(savedOrderEntity);
    }

}
