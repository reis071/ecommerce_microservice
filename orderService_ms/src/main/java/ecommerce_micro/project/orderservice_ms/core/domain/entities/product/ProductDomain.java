package ecommerce_micro.project.orderservice_ms.core.domain.entities.product;


public class ProductDomain {

    private String code;
    private double unitValue;

    public ProductDomain() {
    }



    public String getCode() {
        return code;
    }

    public void setCode(String codeProduct) {
        this.code = codeProduct;
    }

    public double getUnitValue() {
        return unitValue;
    }

    public void setUnitValue(double unitValue) {
        this.unitValue = unitValue;
    }

    public String toString() {
        return "ProductDomain{" +
                "code='" + code + '\'' +
                ", unitValue=" + unitValue +
                '}';
    }

}
