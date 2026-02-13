package ecommerce_micro.project.orderservice_ms.domain.event;

import ecommerce_micro.project.orderservice_ms.config.mskafka.settings.enums.EEventSource;
import ecommerce_micro.project.orderservice_ms.config.mskafka.settings.enums.ESagaStatus;
import ecommerce_micro.project.orderservice_ms.domain.history.HistoryDomain;
import ecommerce_micro.project.orderservice_ms.domain.order.OrderDomain;

import java.util.List;

public class EventDomain {

    private String id;
    private String transactionId;
    private String orderId;
    private OrderDomain order;
    private EEventSource source;
    private ESagaStatus status;
    private List<HistoryDomain> history;

    public EventDomain() {
    }

    public EventDomain(String id, String transactionId, String orderId, OrderDomain order, EEventSource source, ESagaStatus status, List<HistoryDomain> history) {
        this.id = id;
        this.transactionId = transactionId;
        this.orderId = orderId;
        this.order = order;
        this.source = source;
        this.status = status;
        this.history = history;
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

    public OrderDomain getOrder() {
        return order;
    }

    public void setOrder(OrderDomain order) {
        this.order = order;
    }

    public EEventSource getSource() {
        return source;
    }

    public void setSource(EEventSource source) {
        this.source = source;
    }

    public ESagaStatus getStatus() {
        return status;
    }

    public void setStatus(ESagaStatus status) {
        this.status = status;
    }

    public List<HistoryDomain> getHistory() {
        return history;
    }

    public void setHistory(List<HistoryDomain> history) {
        this.history = history;
    }

    public String toString() {
        return "EventDomain{" +
                "id='" + id + '\'' +
                ", transactionId='" + transactionId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", order=" + order +
                ", source='" + source + '\'' +
                ", status='" + status + '\'' +
                ", history=" + history +
                '}';
    }
}
