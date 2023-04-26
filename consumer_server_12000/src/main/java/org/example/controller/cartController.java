package org.example.controller;

import org.example.model.commonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class cartController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/getUserById/{userId}")
    public commonResult getUserById(@PathVariable Integer userId){
        List<ServiceInstance> instanceList = discoveryClient.getInstances("provider-server");

        ServiceInstance instance = instanceList.get(0);

        commonResult result = restTemplate.getForObject("http://"+instance.getHost()+":"+instance.getPort()+"user/getUserById/"+userId, commonResult.class);
        return result;
    }
}
