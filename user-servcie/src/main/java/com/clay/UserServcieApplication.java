package com.clay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 。@EnableDiscovery Client注解表示这是一个Eureka客户端，通过该注解，
 * 在Spring Boot启动完毕之后，就会根据配置中的信息尝试与服务治理服务器进行连接，连接成功之后进行服务注册或者服务注册信息的同步
 */
@EnableDiscoveryClient
@SpringBootApplication
public class UserServcieApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServcieApplication.class, args);
    }

}
