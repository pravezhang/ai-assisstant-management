package com.lowrisk.aiassistant.management.config.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @company 乐瑞
 * @author 张庭旭
 * @date 2020年7月21日17:31:15
 * @description 封装了一些redis常用方法
 */
@Component
public class RedisManager {
    @Autowired
    @Qualifier("redisTemp")
    private RedisTemplate<String , String> redisTemplate;

    public void put(String key, String value){
        redisTemplate.opsForValue().set(key,value);
    }

    public String get(String key){
        return redisTemplate.opsForValue().get(key);
    }

    public void remove(String key){
        redisTemplate.delete(key);
    }

    public boolean exist(String key){
        Boolean aBoolean = redisTemplate.hasKey(key);
        return aBoolean== null?false:aBoolean;
    }

    public void setPut(String key,String value){
        redisTemplate.opsForSet().add(key,value);
    }

    public Set<String> setGet(String key){
        return redisTemplate.opsForSet().members(key);
    }

    public void zsetPut(String key,String value,Double score){
        redisTemplate.opsForZSet().add(key,value,score);
    }

    public void hashPut(String key,String hash,String value){
        redisTemplate.opsForHash().put(key,hash,value);
    }

    public String  hashGet(String key,String hash){
        return String.valueOf(redisTemplate.opsForHash().get(key,hash));
    }

    public void hashRemove(String key,String hash){
        redisTemplate.opsForHash().delete(key,hash);
    }

}
