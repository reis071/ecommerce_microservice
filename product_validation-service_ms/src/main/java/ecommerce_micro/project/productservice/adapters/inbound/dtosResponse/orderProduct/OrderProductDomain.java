package ecommerce_micro.project.productservice.adapters.inbound.dtosResponse.orderProduct;


import ecommerce_micro.project.productservice.adapters.inbound.dtosResponse.product.ProductDomain;

public record OrderProductDomain

    ( ProductDomain product,
     int quantity)
{


}
