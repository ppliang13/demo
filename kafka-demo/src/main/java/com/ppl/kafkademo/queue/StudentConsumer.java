package com.ppl.kafkademo.queue;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * Created by pisiliang on 2023/6/5 10:36
 */
@Service
public class StudentConsumer {

    @KafkaListener(topics = "canteen-meat", groupId = "student1")
    public void lunch(String message){
        System.out.println("message = " + message);
    }
}
