package ecommerce_micro.project.orderservice_ms.domain.event;

import ecommerce_micro.project.orderservice_ms.config.mskafka.settings.enums.EEventSource;
import ecommerce_micro.project.orderservice_ms.config.mskafka.settings.enums.ESagaStatus;
import ecommerce_micro.project.orderservice_ms.domain.history.HistoryDomain;
import ecommerce_micro.project.orderservice_ms.domain.order.OrderDomain;

import java.time.LocalDateTime;
import java.util.List;

public class EventDomain {

    private String id;
    private String transactionId;
    private String orderId;
    private OrderDomain payload;
    private String source;
    private String status;
    private List<HistoryDomain> history;
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

    public List<HistoryDomain> getHistory() {
        return history;
    }

    public void setHistory(List<HistoryDomain> history) {
        this.history = history;
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
                ", history=" + history +
                ", createdAt=" + createdAt +
                '}';
    }
}
