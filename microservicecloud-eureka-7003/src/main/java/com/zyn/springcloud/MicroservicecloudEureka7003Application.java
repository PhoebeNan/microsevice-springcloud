package com.zyn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer  //表示此spingboot应用程序是EurekaServer服务器端的启动类，接受其他微服务注册进来
public class MicroservicecloudEureka7003Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicecloudEureka7003Application.class, args);
    }

}
