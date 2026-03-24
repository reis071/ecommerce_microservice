package ecommerce_micro.project.orchestratorservice_ms.config.kafka.settings;

import ecommerce_micro.project.orchestratorservice_ms.config.kafka.settings.enums.ETopics;

import static ecommerce_micro.project.orchestratorservice_ms.config.kafka.settings.enums.EEventSource.ORDER_SERVICE;

import static ecommerce_micro.project.orchestratorservice_ms.config.kafka.settings.enums.ESagaStatus.SUCCESS;
import static ecommerce_micro.project.orchestratorservice_ms.config.kafka.settings.enums.ETopics.PRODUCT_VALIDATOR_SUCCES;

public final class SagaHandler {


    public SagaHandler() {
    }

    public static final Object[][] SAGA_HANDLER = {
            {ORDER_SERVICE, SUCCESS, PRODUCT_VALIDATOR_SUCCES}
    };

    public static final int EVENT_SOURCE_INDEX = 0;
    public static final int STATUS_INDEX = 1;
    public static final int TOPIC_INDEX = 2;

}
