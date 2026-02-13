package ecommerce_micro.project.orchestratorservice_ms.adapters.inbound.dtosResponse.orderProduct;


import ecommerce_micro.project.orchestratorservice_ms.adapters.inbound.dtosResponse.product.ProductDomain;

public record OrderProductDomain

    ( ProductDomain product,
     int quantity)
{


}
