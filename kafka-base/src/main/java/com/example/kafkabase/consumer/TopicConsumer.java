package com.example.kafkabase.consumer;

import com.example.kafkabase.dto.MoneyMessage;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class TopicConsumer {

    @KafkaListener(topics = "info")
    public void onMessage(MoneyMessage record){
        System.out.println("消费者消费，record："+record);
    }




//
//    @KafkaListener(topics = KafkaConfig.TOPIC_N, groupId = "my-group", containerFactory = "kafkaListenerContainerFactory")
//    public void onMessage(String message , Acknowledgment acknowledgment) {
//        System.out.println(message);
//        acknowledgment.acknowledge();
//    }


}