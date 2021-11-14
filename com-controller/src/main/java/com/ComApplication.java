package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"dao","com.controller","service","aop"})
 @MapperScan("dao")
public class ComApplication {
    public static void main(String[] args) {
         SpringApplication.run(ComApplication.class, args);
     }
}
