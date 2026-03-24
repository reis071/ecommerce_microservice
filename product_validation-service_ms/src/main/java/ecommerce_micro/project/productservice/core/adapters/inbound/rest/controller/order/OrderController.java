package ecommerce_micro.project.orderservice_ms.core.adapters.inbound.rest.controller.order;

import ecommerce_micro.project.orderservice_ms.core.application.dtoRequest.order.OrderDTORequest;
import ecommerce_micro.project.orderservice_ms.core.application.service.order.OrderService;
import ecommerce_micro.project.orderservice_ms.core.domain.entities.order.OrderDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("order/v1")
public class OrderController {
    private final OrderService orderService;

    @PostMapping("register")
    public ResponseEntity<OrderDomain> registerOrder(@RequestBody OrderDTORequest OrderDTORequest) {
        OrderDomain order = orderService.registerOrder(OrderDTORequest);
        return ResponseEntity.ok(order);
    }
}
