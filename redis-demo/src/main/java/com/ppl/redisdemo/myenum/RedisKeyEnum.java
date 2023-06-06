package com.ppl.redisdemo.myenum;

/**
 * Created by pisiliang on 2023/6/6 16:27
 */
public enum RedisKeyEnum {
    STRING_KEY("key:str1","字符串"),
    SET_KEY("key:set1","无序set"),
    ZSET_KEY("key:zset1","有序set"),
    MAP_KEY("key:map1","map"),
    ;

    RedisKeyEnum(String key, String name) {
        this.key = key;
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    private final String key;
    private final String name;
}
