package com.example.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "GMALL-EUREKA-PROVIDER")
public interface ProService {
    @GetMapping("/provider/getString")
    String getString();
}
