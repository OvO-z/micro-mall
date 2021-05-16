package com.micro.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MyBatis相关配置
 * @author QAQ
 * @date 2021/5/15
 */

@Configuration
@EnableTransactionManagement
@MapperScan({"com.micro.mall.mapper", "com.micro.mall.dao"})
public class MybatisConfig {
}
