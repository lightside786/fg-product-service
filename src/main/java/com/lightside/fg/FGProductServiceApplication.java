package com.lightside.fg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class FGProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FGProductServiceApplication.class, args);
    }
}
