package ecommerce_micro.project.orderservice_ms.core.domain.entities.orderProduct;

import ecommerce_micro.project.orderservice_ms.core.domain.entities.product.ProductDomain;

public class OrderProductDomain {

    private ProductDomain product;
    private int quantity;

    public OrderProductDomain() {
    }


    public ProductDomain getProduct() {
        return product;
    }

    public void setProduct(ProductDomain product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String toString() {
        return "OrderProductDomain{" +
                "product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
