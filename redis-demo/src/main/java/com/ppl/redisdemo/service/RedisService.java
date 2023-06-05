package com.ppl.redisdemo.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pisiliang on 2023/6/5 17:31
 */
@Service
public class RedisService {

    /**
     * 将结果集缓存，当结果集已缓存，从缓存中获取结果集，一般长用于数据删除
     * @return list
     */
    @Cacheable(value = "cacheTest#60",key = "#root.methodName")
    public List<String> getRedisCache(){
        List<String> list = new ArrayList<>();
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        list.add("test");
        return list;
    }


}
