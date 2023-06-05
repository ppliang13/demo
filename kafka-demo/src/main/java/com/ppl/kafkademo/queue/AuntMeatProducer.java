package com.ppl.kafkademo.queue;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by pisiliang on 2023/6/5 10:34
 */
@Service
public class AuntMeatProducer {

    @Resource
    private KafkaTemplate<String,String> kafkaTemplate;


    public void chicken(){
        kafkaTemplate.send("canteen-meat","干锅鸡块");
    }

}
