package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class eurekaServerApplication13001 {

    public static void main(String[] args) {
        SpringApplication.run(eurekaServerApplication13001.class, args);
    }
}
