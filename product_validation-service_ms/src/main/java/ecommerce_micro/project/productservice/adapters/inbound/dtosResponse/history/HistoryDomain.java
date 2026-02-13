package ecommerce_micro.project.productservice.adapters.inbound.dtosResponse.history;


import ecommerce_micro.project.productservice.settings.enums.EEventSource;
import ecommerce_micro.project.productservice.settings.enums.ESagaStatus;

import java.time.LocalDateTime;

public record HistoryDomain

     (EEventSource source,
      ESagaStatus status,
      String message,
      LocalDateTime createdAt)

{


}
