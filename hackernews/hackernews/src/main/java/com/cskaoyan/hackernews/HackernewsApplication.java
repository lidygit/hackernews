package com.cskaoyan.hackernews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class HackernewsApplication {

    public static void main(String[] args) {
        SpringApplication.run(HackernewsApplication.class, args);
    }

}

