package ecommerce_micro.project.orderservice_ms.core.application.usecases.order;

import ecommerce_micro.project.orderservice_ms.core.application.dtoRequest.order.OrderDTORequest;
import ecommerce_micro.project.orderservice_ms.core.domain.entities.order.OrderDomain;

public interface OrderUseCases {

    OrderDomain registerOrder(OrderDTORequest OrderDTORequest);

    void eventRegisterOrder(OrderDomain order);
}
