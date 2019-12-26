package com.zyn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //本服务启动后将自动把自己注册到eureka服务中
@EnableDiscoveryClient //服务发现
@EnableCircuitBreaker //服务熔断
public class MicroservicecloudProviderDept8001HystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicecloudProviderDept8001HystrixApplication.class, args);
    }

}
