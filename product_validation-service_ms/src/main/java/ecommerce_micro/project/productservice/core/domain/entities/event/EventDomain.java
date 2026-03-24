package ecommerce_micro.project.orderservice_ms.core.domain.entities.event;

import ecommerce_micro.project.orderservice_ms.core.domain.entities.history.HistoryDomain;
import ecommerce_micro.project.orderservice_ms.core.domain.entities.order.OrderDomain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EventDomain {

    private String id;
    private String transactionId;
    private String orderId;
    private OrderDomain payload;
    private String source;
    private String status;
    private List<HistoryDomain> eventHistory = new ArrayList<>();
    private LocalDateTime    createdAt;

    public EventDomain() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public OrderDomain getPayload() {
        return payload;
    }

    public void setPayload(OrderDomain payload) {
        this.payload = payload;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<HistoryDomain> getEventHistory() {
        return eventHistory;
    }

    public void setEventHistory(List<HistoryDomain> eventHistory) {
        this.eventHistory = eventHistory;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "EventDomain{" +
                "id='" + id + '\'' +
                ", transactionId='" + transactionId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", payload=" + payload +
                ", source='" + source + '\'' +
                ", status='" + status + '\'' +
                ", eventHistory=" + eventHistory +
                ", createdAt=" + createdAt +
                '}';
    }
}
