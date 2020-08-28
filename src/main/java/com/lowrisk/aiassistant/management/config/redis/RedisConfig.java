package com.lowrisk.aiassistant.management.config.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @company 乐瑞
 * @author 张庭旭
 * @date 2020年7月21日14:31:15
 * @description redis的配置类
 */
@Configuration
@PropertySource("classpath:redis.yml")
public class RedisConfig {

    @Bean("redisTemp")
    public RedisTemplate<String ,String > getRedis(LettuceConnectionFactory factory){
        RedisTemplate<String , String> template = new RedisTemplate<>();
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new StringRedisSerializer());
        template.setConnectionFactory(factory);
        return template;
    }
}
