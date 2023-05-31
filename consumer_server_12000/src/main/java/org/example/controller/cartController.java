package org.example.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.example.feign.userFeignClient;
import org.example.model.commonResult;
import org.example.model.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/cart")
public class cartController {

//    @Autowired
//    private RestTemplate restTemplate;
//
//    @DeleteMapping("/deleteUser/{userId}")
//    public void deleteUser(@PathVariable Integer userId){
//        restTemplate.delete("http://provider-server/user/deleteUser/"+userId);
//    }
//
//    @PutMapping("/updateUser/{userId}/{username}")
//    public void updateUser(@PathVariable Integer userId, @PathVariable String username){
//        restTemplate.put("http://provider-server/user/updateUserById/"+userId+"/"+username,null);
//    }
//
//    @PostMapping("/createUser/")
//    public commonResult createUser(@ModelAttribute user user){
//        System.out.println(user.getName()+user.getId()+user.getAge()+user.getPassword());
//        commonResult result = restTemplate.postForObject("http://provider-server/user/createUser/",user, commonResult.class);
//        return result;
//    }
//
//    @GetMapping("/getUserById/{userId}")
//    public commonResult getUserById(@PathVariable Integer userId){
//        commonResult result = restTemplate.getForObject("http://provider-server/user/getUserById/"+userId, commonResult.class);
//        return result;
//    }

    @Autowired
    private userFeignClient userFeignClient;

    @GetMapping("/getUserById1/{userId}")
    public commonResult getUserById1(@PathVariable("userId") Integer userId){
        return userFeignClient.getUserById1(userId);
    }
    @GetMapping("/getUserById2/{userName}")
    public commonResult getUserById2(@PathVariable("userName") String userName){
        return userFeignClient.getUserById2(userName);
    }
}
