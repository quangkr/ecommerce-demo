package com.dxc.qdang.ecommercedemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.PageableHandlerMethodArgumentResolverCustomizer;

@Configuration
public class PageableConfig {

    @Bean
    PageableHandlerMethodArgumentResolverCustomizer pageableCustomizer() {
        return p -> p.setOneIndexedParameters(true);
    }

}
