package com.zh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.zh.controller"})
public class CommunApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommunApplication.class, args);
    }

}
