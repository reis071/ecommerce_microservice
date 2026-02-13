package ecommerce_micro.project.orderservice_ms.domain.product;


public class ProductDomain {

    private String codeProduct;
    private double unitValue;

    public ProductDomain() {
    }

    public ProductDomain(String codeProduct, double unitValue) {
        this.codeProduct = codeProduct;
        this.unitValue = unitValue;
    }

    public String getCodeProduct() {
        return codeProduct;
    }

    public void setCodeProduct(String codeProduct) {
        this.codeProduct = codeProduct;
    }

    public double getUnitValue() {
        return unitValue;
    }

    public void setUnitValue(double unitValue) {
        this.unitValue = unitValue;
    }

    public String toString() {
        return "ProductDomain{" +
                "codeProduct='" + codeProduct + '\'' +
                ", unitValue=" + unitValue +
                '}';
    }

}
