package ecommerce_micro.project.orchestratorservice_ms.config.kafka.settings.enums;


public enum ETopics {

    START_SAGA("start-saga"),
    ORCHESTRATOR("orchestrator"),
    FINISH_SUCCESS("finish-success"),
    FINISH_FAIL("finish-fail"),
    PRODUCT_VALIDATOR_SUCCES("product-validator-success"),
    PRODUCT_VALIDATOR_FAIL("product-validator-fail"),
    PAYMENT_SUCCESS("payment-success"),
    PAYMENT_FAIL("payment-fail"),
    INVENTORY_SUCCESS("inventory-success"),
    INVENTORY_FAIL("inventory-fail"),
    NOTIFY_END("notify-end");

    ETopics(String topicName) {
        this.topicName = topicName;
    }

    private String topicName;

    public String getTopicName() {
        return topicName;
    }
}
