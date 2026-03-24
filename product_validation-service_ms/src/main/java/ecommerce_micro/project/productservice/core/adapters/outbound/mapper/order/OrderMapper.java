package ecommerce_micro.project.productservice.core.adapters.outbound.mapper.order;

import ecommerce_micro.project.orderservice_ms.core.adapters.outbound.repositories.entities.order.OrderEntity;
import ecommerce_micro.project.orderservice_ms.core.domain.entities.order.OrderDomain;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderEntity toEntity(OrderDomain orderDomain);
    OrderDomain toDomain(OrderEntity orderEntity);
}
