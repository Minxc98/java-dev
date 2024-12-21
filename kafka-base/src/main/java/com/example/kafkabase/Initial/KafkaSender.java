package com.example.kafkabase.Initial;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaSender implements InitializingBean {

    @Autowired
    private KafkaTemplate<Object,Object> kafkaTemplate;



    @Override
    public void afterPropertiesSet() throws Exception {
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 0L,
//                TimeUnit.MILLISECONDS,
//                new ArrayBlockingQueue<>(10),
//                new ThreadPoolExecutor.CallerRunsPolicy());
//        while (true) {
//            executor.submit(()->{
//                System.out.println("sender send info");
//                kafkaTemplate.send(TOPIC_N, new MoneyMessage(1L, 100L, LocalDate.now()));
//            });
//            TimeUnit.SECONDS.sleep(2);
//        }

    }
}
