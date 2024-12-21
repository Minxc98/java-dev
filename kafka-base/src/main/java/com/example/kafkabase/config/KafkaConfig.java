package com.example.kafkabase.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

//    public static final String TOPIC_N = "info";
//
//    @Value("${spring.kafka.bootstrap-servers:127.0.0.1:9092}")
//    private String bootstrapServers;
//
//    @Bean
//    public Map<String, Object> producerConfigs() {
//        Map<String, Object> props = new HashMap<>();
//        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
//        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        props.put(ProducerConfig.ACKS_CONFIG, "1"); // 设置ack参数为1
//        return props;
//    }
//
//    @Bean
//    public ProducerFactory<Object, Object> producerFactory() {
//        return new DefaultKafkaProducerFactory<>(producerConfigs());
//    }
//
//    @Bean
//    public KafkaTemplate<Object, Object> kafkaTemplate() {
//        return new KafkaTemplate<>(producerFactory());
//    }
//    @Bean
//    public NewTopic createTopic() {
//        return new NewTopic(TOPIC_N, 1, (short) 1);
//    }

//    @Bean("myKafkaContainerFactory")
//    @ConditionalOnBean(ConcurrentKafkaListenerContainerFactoryConfigurer.class)
//    public ConcurrentKafkaListenerContainerFactory<?, ?> kafkaListenerContainerFactory(
//            ConcurrentKafkaListenerContainerFactoryConfigurer configurer) {
//        ConcurrentKafkaListenerContainerFactory<Object, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
//        configurer.configure(factory, consumerFactory());
//        return factory;
//    }

//    //获得创建消费者工厂
//    public ConsumerFactory<Object, Object> consumerFactory() {
//        KafkaProperties myKafkaProperties = JSON.parseObject(JSON.toJSONString(this.properties), KafkaProperties.class);
//        //对模板 properties 进行定制化
//        //....
//        //例如：定制servers
//        myKafkaProperties.setBootstrapServers(myServers);
//        return new DefaultKafkaConsumerFactory<>(myKafkaProperties.buildConsumerProperties());
//    }
//
//    /**
//     *  消费者批量工厂
//     */
//    @Bean
//    public KafkaListenerContainerFactory<?> batchFactory() {
//        ConcurrentKafkaListenerContainerFactory<Integer, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(new DefaultKafkaConsumerFactory<>(consumerConfigs()));
//        //设置并发量，小于或等于Topic的分区数
//        factory.setConcurrency(batchConcurrency);
//        factory.getContainerProperties().setPollTimeout(1500);
//        //配置监听手动提交 ack，消费一条数据完后，立即提交
//        factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL_IMMEDIATE);
//        //设置为批量消费，每个批次数量在Kafka配置参数中设置ConsumerConfig.MAX_POLL_RECORDS_CONFIG
//        factory.setBatchListener(true);
//        return factory;
//    }
}
