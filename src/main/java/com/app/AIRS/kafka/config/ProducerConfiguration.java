package com.app.AIRS.kafka.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

@Configuration
public class ProducerConfiguration {

    private final Logger logger = Logger.getLogger(ProducerConfiguration.class.getSimpleName());

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Value("${topicIndividual}")
    private String topicIndividual;

    @Value("${topicCorporate}")
    private String topicCorporate;

//    @Bean
//    public ProducerFactory<String, Object> producerFactory() {
//        Map<String, Object> props = new HashMap<String, Object>();
//        logger.info(bootstrapServers);
//        // props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, hostAndPort);
//        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
//        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
//        props.put(ConsumerConfig.GROUP_ID_CONFIG, "tutorialGroup");
//        // props.put(ProducerConfig.TRANSACTION_TIMEOUT_CONFIG, 0);
//        return new DefaultKafkaProducerFactory<>(props);
//    }
//
//    @Bean
//    public KafkaTemplate<String, Object> kafkaTemplate() {
//        return new KafkaTemplate<>(producerFactory());
//    }
//
//    @Bean
//    public NewTopic enumerationForIndividualTopic() {
//        return TopicBuilder.name(String.valueOf(TopicName.valueOf(topicIndividual.toUpperCase())).toLowerCase()).build();
//    }
//
//    @Bean
//    public NewTopic enumerationForCorporateTopic() {
//        return TopicBuilder.name(String.valueOf(TopicName.valueOf(topicCorporate.toUpperCase())).toLowerCase()).build();
//    }
}
