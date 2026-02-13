package ecommerce_micro.project.orchestratorservice_ms.adapters.inbound.dtosResponse.history;

import ecommerce_micro.project.orchestratorservice_ms.config.kafka.settings.enums.EEventSource;
import ecommerce_micro.project.orchestratorservice_ms.config.kafka.settings.enums.ESagaStatus;

import java.time.LocalDateTime;

public record HistoryDomain

     (EEventSource source,
      ESagaStatus status,
      String message,
      LocalDateTime createdAt)

{


}
