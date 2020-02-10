package com.example.demo.Controller;



import com.example.demo.service.ProService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class UserController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ProService proService;

    @GetMapping("/discovery")
    public Object discovery(){
        return restTemplate.getForEntity("http://localhost:8001/discovery",Object.class);
    }

    @GetMapping("/getString")
    public String  getString(){
        //return restTemplate.getForObject("http://gmall-eureka-provider/provider/getString",String.class);
        return proService.getString();
    }
}
