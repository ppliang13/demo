package com.ppl.redisdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by pisiliang on 2023/6/6 15:51
 */
@Service
public class RedisToolService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    void test(){
        redisTemplate.opsForHash();
    }

    /**
     * 存储字符串类型的方法
     * @param key key名称
     * @param value 值
     * @param seconds 存多少秒
     * @see ValueOperations 方法
     */
    public void setString(String key, String value,Long seconds) {
         redisTemplate.opsForValue().set(key, value,seconds, TimeUnit.SECONDS);
    }
    public void setString(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    // 查询字符串类型
    public String getString(String key) {
        ValueOperations<String, Object> ops = redisTemplate.opsForValue();
        return (String) ops.get(key);
    }

    // 存储 List 类型
    public void setList(String key, List<Object> list,Long seconds) {
        ListOperations<String, Object> ops = redisTemplate.opsForList();
        ops.leftPushAll(key, list);
        redisTemplate.expire(key,seconds,TimeUnit.SECONDS);
    }

    // 查询 List 类型
    public List<Object> getList(String key) {
        ListOperations<String, Object> ops = redisTemplate.opsForList();
        Long size = ops.size(key);
        return ops.range(key, 0, size);
    }

    // 存储 Set 类型
    public void setSet(String key, Set<Object> set) {
        SetOperations<String, Object> ops = redisTemplate.opsForSet();
        ops.add(key, set.toArray());
    }

    // 查询 Set 类型
    public Set<Object> getSet(String key) {
        SetOperations<String, Object> ops = redisTemplate.opsForSet();
        return ops.members(key);
    }

    // 存储 Hash 类型
    public void setHash(String key, Map<String, Object> map) {
        HashOperations<String, String, Object> ops = redisTemplate.opsForHash();
        ops.putAll(key, map);
    }

    // 查询 Hash 类型
    public Map<String, Object> getHash(String key) {
        HashOperations<String, String, Object> ops = redisTemplate.opsForHash();
        return ops.entries(key);
    }

    // 存储 ZSet 类型
//    public void setZSet(String key, Map<Object, Double> map) {
//        ZSetOperations<String, Object> ops = redisTemplate.opsForZSet();
//        Set<DefaultTypedTuple<Object>> tuples = new HashSet<>();
//        for (Map.Entry<Object, Double> entry : map.entrySet()) {
//            DefaultTypedTuple<Object> tuple = new DefaultTypedTuple<>(entry.getKey(), entry.getValue());
//            tuples.add(tuple);
//        }
//        ops.add(key, tuples);
//    }

    // 查询 ZSet 类型
    public Set<Object> getZSet(String key) {
        ZSetOperations<String, Object> ops = redisTemplate.opsForZSet();
        return ops.range(key, 0, -1);
    }

}
