package ecommerce_micro.project.productservice.core.domain.entities.history;

import ecommerce_micro.project.orderservice_ms.config.mskafka.settings.enums.ESagaStatus;

import java.time.LocalDateTime;

public class HistoryDomain {

    private String  source;
    private ESagaStatus status;
    private String message;
    private LocalDateTime createdAt;

    public HistoryDomain() {
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public ESagaStatus getStatus() {
        return status;
    }

    public void setStatus(ESagaStatus status) {
        this.status = status;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String toString() {
        return "HistoryDomain{" +
                "source='" + source + '\'' +
                ", status=" + status +
                ", message='" + message + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
