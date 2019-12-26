package com.zyn.springcloud.service;

import com.zyn.springcloud.entities.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zhaoyanan
 * @create 2019-12-26-10:25
 */
@Component
public class DeptClientServiceFallBackFactory implements FallbackFactory<DeptClientService> {

    @Override
    public DeptClientService create(Throwable throwable) {

        return new DeptClientService() {
            @Override
            public Dept get(Long id) {

                return new Dept().setDeptno(id).setDname("该ID"+id+"没有对应的信息,Consumer客户端提供的降级信息,此服务Provider已经关闭")
                        .setDb_source("no this database in Mysql");
            }

            @Override
            public List<Dept> list() {
                return null;
            }

            @Override
            public boolean add(Dept dept) {
                return false;
            }
        };
    }
}
