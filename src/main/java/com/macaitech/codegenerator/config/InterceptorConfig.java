package com.macaitech.codegenerator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.macaitech.codegenerator.interceptor.GlobalInterceptor;

@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {

    @Bean
    public GlobalInterceptor globalInterceptor() {
        return new GlobalInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(globalInterceptor()).addPathPatterns("/**");
    }
}
