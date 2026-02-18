package ecommerce_micro.project.orderservice_ms.core.adapters.outbound.repositories.entities.event;

import ecommerce_micro.project.orderservice_ms.core.adapters.outbound.repositories.entities.history.HistoryEntity;
import ecommerce_micro.project.orderservice_ms.core.adapters.outbound.repositories.entities.order.OrderEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "events")
public class EventEntity {

    @Id
    private String id;

    private String transactionId;
    private String orderId;
    private OrderEntity payload;
    private String source;
    private String status;
    private List<HistoryEntity> eventHistory = new ArrayList<>();
    private LocalDateTime createdAt;


}
