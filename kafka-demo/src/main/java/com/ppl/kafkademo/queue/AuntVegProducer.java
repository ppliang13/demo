package com.ppl.kafkademo.queue;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by pisiliang on 2023/6/5 10:35
 */
@Service
public class AuntVegProducer {
    @Resource
    private KafkaTemplate<String,String> kafkaTemplate;


    public void RedRadish(){
        kafkaTemplate.send("canteen-veg","红萝卜");
    }

    public void WhiteRadish(){
        kafkaTemplate.send("canteen-veg","白萝卜");
    }
}
