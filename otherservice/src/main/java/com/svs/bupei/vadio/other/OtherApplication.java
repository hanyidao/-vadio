package com.svs.bupei.vadio.other;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OtherApplication {

    public static void main(String[] args) {
        SpringApplication.run(OtherApplication.class,args);
    }

}
