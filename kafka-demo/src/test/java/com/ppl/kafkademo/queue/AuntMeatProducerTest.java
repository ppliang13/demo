package com.ppl.kafkademo.queue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * Created by pisiliang on 2023/6/5 13:41
 */
@SpringBootTest
class AuntMeatProducerTest {

    @Resource
    private AuntMeatProducer auntMeatProducer;
    @Resource
    private AuntRiceProducer auntRiceProducer;
    @Resource
    private AuntVegProducer auntVegProducer;

    @Resource
    private StudentConsumer studentProducer;

    @Test
    void init() {
        auntMeatProducer.chicken();
        auntRiceProducer.rice();
        auntVegProducer.RedRadish();
        auntVegProducer.WhiteRadish();
    }


}