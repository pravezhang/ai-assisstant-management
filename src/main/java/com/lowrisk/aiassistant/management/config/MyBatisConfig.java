package com.lowrisk.aiassistant.management.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @company 乐瑞
 * @author 张庭旭
 * @date 2020年7月21日15:32:15
 * @description mybatis配置类
 */
@Configuration
@PropertySource("classpath:jdbc.properties")
@MapperScan(basePackages = {"com.lowrisk.aiassisstant.management.db.mapper"})
public class MyBatisConfig {

}
