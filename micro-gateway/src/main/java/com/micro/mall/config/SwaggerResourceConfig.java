package com.micro.mall.config;

import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.List;

/**
 * Swagger资源配置
 * @author QAQ
 * @date 2021/5/17
 */

public class SwaggerResourceConfig implements SwaggerResourcesProvider {
    @Override
    public List<SwaggerResource> get() {
        return null;
    }
}
