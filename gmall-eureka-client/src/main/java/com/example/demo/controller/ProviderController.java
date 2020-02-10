package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 服务提供者
 */
@RestController
@RequestMapping("/provider")
public class ProviderController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();//查询所有的服务
        services.forEach(System.out::println);
        System.out.println("--------------------------");
        List<ServiceInstance> instances = discoveryClient.getInstances("gmall-eureka-client");//通过serviceId 查询实例服务
        for (ServiceInstance instance : instances) {
            System.out.println("主机地址为:"+instance.getHost()+"端口号:"+instance.getPort()+"InstanceId："+instance.getInstanceId()+"ServiceId"+instance.getServiceId());
        }
        return this.discoveryClient;
    }

    @GetMapping("/getString")
    public String getString(){
        return "获取服务";
    }
}
