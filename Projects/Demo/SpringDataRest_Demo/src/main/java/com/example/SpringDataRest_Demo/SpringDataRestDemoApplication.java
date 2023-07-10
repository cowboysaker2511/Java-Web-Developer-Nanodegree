package com.example.SpringDataRest_Demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringDataRestDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataRestDemoApplication.class, args);
    }

}
