package com.hsl.springboot03.config;

/**
 * @author water
 * @site www.water.com
 * @company xxx公司
 * @create 2020-01-02 18:24
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 资源映射路径
 */
@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurationSupport {
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/uploadImages/**").addResourceLocations("file:E:/img/");
        super.addResourceHandlers(registry);
    }
}
