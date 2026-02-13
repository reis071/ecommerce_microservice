package ecommerce_micro.project.orchestratorservice_ms.adapters.inbound.dtosResponse.event;



import ecommerce_micro.project.orchestratorservice_ms.adapters.inbound.dtosResponse.history.HistoryDomain;
import ecommerce_micro.project.orchestratorservice_ms.adapters.inbound.dtosResponse.order.OrderDomain;
import ecommerce_micro.project.orchestratorservice_ms.config.kafka.settings.enums.EEventSource;
import ecommerce_micro.project.orchestratorservice_ms.config.kafka.settings.enums.ESagaStatus;

import java.util.List;

public record EventDomain
    ( String id,
     String transactionId,
     String orderId,
     OrderDomain order,
     EEventSource source,
     ESagaStatus status,
     List<HistoryDomain> history) {
}
