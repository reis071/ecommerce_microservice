package ecommerce_micro.project.orderservice_ms.core.adapters.outbound.repositories.entities.history;


import ecommerce_micro.project.orderservice_ms.config.mskafka.settings.enums.ESagaStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistoryEntity {

    private String  source;
    private ESagaStatus status;
    private String message;
    private LocalDateTime createdAt;

}
