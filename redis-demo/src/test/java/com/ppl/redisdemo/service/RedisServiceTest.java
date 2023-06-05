package com.ppl.redisdemo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * Created by pisiliang on 2023/6/5 17:32
 */
@SpringBootTest
class RedisServiceTest {

    @Autowired
    private RedisService redisService;
    @Test
    void getRedisCache() {
        List<String> redisCache = redisService.getRedisCache();
        System.out.println("redisCache = " + redisCache);
        List<String> redisCache1 = redisService.getRedisCache();
        System.out.println("redisCache1 = " + redisCache1);
        List<String> redisCache2 = redisService.getRedisCache();
        System.out.println("redisCache2 = " + redisCache2);
    }
}