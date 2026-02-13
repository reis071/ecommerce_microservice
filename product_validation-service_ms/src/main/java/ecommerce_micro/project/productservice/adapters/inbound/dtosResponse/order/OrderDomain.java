package ecommerce_micro.project.productservice.adapters.inbound.dtosResponse.order;


import ecommerce_micro.project.productservice.adapters.inbound.dtosResponse.orderProduct.OrderProductDomain;

import java.time.LocalDateTime;
import java.util.List;

public record OrderDomain

    ( String id,
     List<OrderProductDomain> orderProducts,
     LocalDateTime createdAt,
     String transactionId,
     double totalAmount,
     int totalItems)
{


}
