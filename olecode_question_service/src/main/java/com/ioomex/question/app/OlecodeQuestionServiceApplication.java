package com.ioomex.question.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableCaching
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@MapperScan("com.ioomex.question.app.mapper")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.ioomex.service.client.service"})
public class OlecodeQuestionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OlecodeQuestionServiceApplication.class, args);
    }

}
