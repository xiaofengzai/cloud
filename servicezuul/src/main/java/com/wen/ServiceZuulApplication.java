package com.wen;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@EnableDiscoveryClient
@RefreshScope //配置刷新
@RestController
public class ServiceZuulApplication {
    @Value("${zuul.routes.api-c.path}")
    private String test;
    public static void main(String[] args) {
        SpringApplication.run( ServiceZuulApplication.class, args );
    }

    // 测试动态修改配置
    @GetMapping("test")
    public String test(){
        return test;
    }
}