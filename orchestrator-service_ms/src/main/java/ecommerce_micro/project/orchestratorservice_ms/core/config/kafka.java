package ecommerce_micro.project.orchestratorservice_ms.core.config;

import ecommerce_micro.project.orchestratorservice_ms.topics.enums.ETopics;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.*;

import java.util.HashMap;
import java.util.Map;

import static ecommerce_micro.project.orchestratorservice_ms.topics.enums.ETopics.*;

@EnableKafka
@Configuration
public class kafka {

    private static final int REPLICA_COUNT = 1;
    private static final int PARTITION_COUNT = 1;

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Value("${spring.kafka.consumer.group-id}")
    private String groupId;

    @Value("${spring.kafka.consumer.auto-offset-reset}")
    private String autoOffsetReset;

    @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfig());
    }

    private Map<String, Object> consumerConfig() {
        HashMap<String, Object> props = new HashMap<>();

        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, autoOffsetReset);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

        return props;
    }

    @Bean
    public ProducerFactory<String, String> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfig());
    }

    private Map<String, Object> producerConfig() {
        HashMap<String, Object> props = new HashMap<>();

        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

        return props;
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

    private NewTopic createTopic(String topicName) {
        return TopicBuilder.name(topicName)
                .partitions(PARTITION_COUNT)
                .replicas(REPLICA_COUNT)
                .build();
    }

    @Bean
    public NewTopic createStartSagaTopic() {
        return createTopic(START_SAGA.getTopicName());
    }

    @Bean
    public NewTopic createOrchestratorTopic() {
        return createTopic(ORCHESTRATOR.getTopicName());
    }

    @Bean
    public NewTopic createFinishSuccessTopic() {
        return createTopic(FINISH_SUCCESS.getTopicName());
    }

    @Bean
    public NewTopic createFinishFailTopic() {
        return createTopic(FINISH_FAIL.getTopicName());
    }

    @Bean
    public NewTopic createProductValidatorSuccessTopic() {
        return createTopic(PRODUCT_VALIDATOR_SUCCES.getTopicName());
    }

    @Bean
    public NewTopic createProductValidatorFailTopic() {
        return createTopic(PRODUCT_VALIDATOR_FAIL.getTopicName());
    }

    @Bean
    public NewTopic createPaymentSuccessTopic() {
        return createTopic(PAYMENT_SUCCESS.getTopicName());
    }

    @Bean
    public NewTopic createPaymentFailTopic() {
        return createTopic(PAYMENT_FAIL.getTopicName());
    }

    @Bean
    public NewTopic createInventorySuccessTopic() {
        return createTopic(INVENTORY_SUCCESS.getTopicName());
    }

    @Bean
    public NewTopic createInventoryFailTopic() {
        return createTopic(INVENTORY_FAIL.getTopicName());
    }

    @Bean
    public NewTopic createNotifyEndTopic() {
        return createTopic(NOTIFY_END.getTopicName());
    }

}
