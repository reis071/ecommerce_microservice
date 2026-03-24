package ecommerce_micro.project.productservice.core.adapters.outbound.repositories.entities.orderProduct;

import ecommerce_micro.project.orderservice_ms.core.adapters.outbound.repositories.entities.product.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderProductEntity {

    private ProductEntity product;
    private int quantity;

}
