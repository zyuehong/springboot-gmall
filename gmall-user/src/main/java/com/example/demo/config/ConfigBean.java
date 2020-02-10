package com.example.demo.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {
    @Bean
    @LoadBalanced  //SpringCloud Ribbon 是基于Netfix Ribbon实现的一套客户端 负载均衡 默认使用轮回
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
