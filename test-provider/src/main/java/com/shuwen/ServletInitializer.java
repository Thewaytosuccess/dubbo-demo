package com.shuwen;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.shuwen")
@EnableDubbo
public class ServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(ServletInitializer.class,args);
    }

}
