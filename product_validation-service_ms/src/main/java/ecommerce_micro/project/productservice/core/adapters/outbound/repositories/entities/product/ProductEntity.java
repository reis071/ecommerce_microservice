package ecommerce_micro.project.productservice.core.adapters.outbound.repositories.entities.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {

    private String code;
    private double unitValue;

}
