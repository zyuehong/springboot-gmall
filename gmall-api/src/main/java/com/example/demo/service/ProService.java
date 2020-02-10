package com.example.demo.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "GMALL-EUREKA-PROVIDER")
public interface ProService {
    @GetMapping("/provider/getString")
    String getString();
}
