package com.micro.mall.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import com.micro.mall.common.config.BaseSwaggerConfig;
import com.micro.mall.common.domain.SwaggerProperties;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author QAQ
 * @date 2021/5/17
 */

@Configuration
@EnableSwagger2
@EnableKnife4j
public class SwaggerConfig extends BaseSwaggerConfig {
    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("com.micro.mall.controller")
                .title("micro-product 服务")
                .description("micro-product 相关接口文档")
                .contactName("QAQ")
                .version("1.0")
                .enableSecurity(true)
                .build();
    }
}
