package ecommerce_micro.project.orderservice_ms.core.adapters.outbound.repositories.entities.order;

import ecommerce_micro.project.orderservice_ms.core.adapters.outbound.repositories.entities.orderProduct.OrderProductEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;


import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "orders")
public class OrderEntity {

    @Id
    private String id;

    private List<OrderProductEntity> products;
    private LocalDateTime createdAt;
    private String transactionId;
    private double totalAmount;
    private int totalItems;


}
