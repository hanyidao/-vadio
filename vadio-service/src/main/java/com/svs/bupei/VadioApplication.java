package com.svs.bupei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class VadioApplication {

    public static void main(String[] args) {
        SpringApplication.run(VadioApplication.class,args);
    }

}
