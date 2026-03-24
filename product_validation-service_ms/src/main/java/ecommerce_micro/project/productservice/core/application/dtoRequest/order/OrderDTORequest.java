package ecommerce_micro.project.productservice.core.application.dtoRequest.order;

import ecommerce_micro.project.orderservice_ms.core.domain.entities.orderProduct.OrderProductDomain;


import java.util.List;

public record OrderDTORequest(List<OrderProductDomain> products) {
}
