package com.ppl.kafkademo.queue;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by pisiliang on 2023/6/5 10:33
 */
@Service
public class AuntRiceProducer {
    @Resource
    private KafkaTemplate<String,String> kafkaTemplate;


    public void rice(){
        kafkaTemplate.send("canteen-rice","米饭");
    }
}
