package ecommerce_micro.project.productservice.adapters.inbound.dtosResponse.event;




import ecommerce_micro.project.productservice.adapters.inbound.dtosResponse.history.HistoryDomain;
import ecommerce_micro.project.productservice.adapters.inbound.dtosResponse.order.OrderDomain;
import ecommerce_micro.project.productservice.settings.enums.EEventSource;
import ecommerce_micro.project.productservice.settings.enums.ESagaStatus;

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
