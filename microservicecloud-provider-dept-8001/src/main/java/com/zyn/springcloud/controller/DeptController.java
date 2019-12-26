package com.zyn.springcloud.controller;

import com.zyn.springcloud.entities.Dept;
import com.zyn.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class DeptController {

  @Autowired
  private DeptService service;

  @Autowired
  private DiscoveryClient discoveryClient;
  
  @RequestMapping(value="/dept/add",method=RequestMethod.POST)
  public boolean add(@RequestBody Dept dept) {
   return service.add(dept);
  }
  
  @RequestMapping(value="/dept/get/{id}",method=RequestMethod.GET)
  public Dept get(@PathVariable("id") Long id) {
    
   return service.get(id);
  }
  
  @RequestMapping(value="/dept/list",method=RequestMethod.GET)
  public List<Dept> list()
  {
   return service.list();
  }

  @RequestMapping(value = "/dept/discovery",method = RequestMethod.GET)
  public Object discovery(){

    List<String> services = discoveryClient.getServices();

    System.out.println(services);

    List<ServiceInstance> serviceInstances = discoveryClient.getInstances("MICROSERVICECLOUD-DEPT");
    for (ServiceInstance serviceInstance : serviceInstances) {
      System.out.println(serviceInstance.getServiceId()+"\t"+serviceInstance.getHost()+"\t"+serviceInstance.getPort()+"\t"+serviceInstance.getUri());

    }

    return this.discoveryClient;
  }
  
}
 

