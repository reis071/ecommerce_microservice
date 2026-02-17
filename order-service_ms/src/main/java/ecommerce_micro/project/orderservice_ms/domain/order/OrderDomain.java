package ecommerce_micro.project.orderservice_ms.domain.order;

import ecommerce_micro.project.orderservice_ms.domain.orderProduct.OrderProductDomain;

import java.time.LocalDateTime;
import java.util.List;

public class OrderDomain {

    private String id;
    private List<OrderProductDomain> products;
    private LocalDateTime createdAt;
    private String transactionId;
    private double totalAmount;
    private int totalItems;

    public OrderDomain() {
    }

    public OrderDomain(String id, List<OrderProductDomain> orderProducts, LocalDateTime createdAt, String transactionId, double totalAmount, int totalItems) {
        this.id = id;
        this.products = orderProducts;
        this.createdAt = createdAt;
        this.transactionId = transactionId;
        this.totalAmount = totalAmount;
        this.totalItems = totalItems;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<OrderProductDomain> getOrderProducts() {
        return products;
    }

    public void setOrderProducts(List<OrderProductDomain> orderProducts) {
        this.products = orderProducts;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public String toString() {
        return "OrderDomain{" +
                "id='" + id + '\'' +
                ", products=" + products +
                ", createdAt=" + createdAt +
                ", transactionId='" + transactionId + '\'' +
                ", totalAmount=" + totalAmount +
                ", totalItems=" + totalItems +
                '}';
    }
}
