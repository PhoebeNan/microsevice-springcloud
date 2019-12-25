package com.zyn.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
 
@Configuration
public class ConfigBean {
    @Bean
    @LoadBalanced //一套客户端的 负载均衡工具
    public RestTemplate getRestTemplate() {

         return new RestTemplate();
    }

    @Bean
    public IRule myRule(){
        return  new RetryRule(); //达到目的，用我们重新选择的随机算法替换掉默认的轮询
    }
}

