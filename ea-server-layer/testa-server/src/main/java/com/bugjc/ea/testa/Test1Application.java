package com.bugjc.ea.testa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Auther: qingyang
 * @Date: 2018/7/22 14:39
 * @Description:
 */
@EnableEurekaClient
@SpringBootApplication
public class Test1Application {

    public static void main(String[] args) {
        SpringApplication.run(Test1Application.class, args);
    }
}