package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = {"dao","com.controller","service","aop","util"})
@MapperScan("dao")
@EnableScheduling
public class ComApplication {
    public static void main(String[] args) {
         SpringApplication.run(ComApplication.class, args);
     }
}
