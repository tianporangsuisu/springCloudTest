package org.example.controller;

import org.example.model.commonResult;
import org.example.model.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/cart")
public class cartController {

    @Autowired
    private RestTemplate restTemplate;

    @DeleteMapping("/deleteUser/{userId}")
    public void deleteUser(@PathVariable Integer userId){
        restTemplate.delete("http://provider-server/user/deleteUser/"+userId);
    }

    @PutMapping("/updateUser/{userId}/{username}")
    public void updateUser(@PathVariable Integer userId, @PathVariable String username){
        restTemplate.put("http://provider-server/user/updateUserById/"+userId+"/"+username,null);
    }

    @PostMapping("/createUser/{userId}")
    public commonResult createUser(@PathVariable Integer userId){
        commonResult result = restTemplate.postForObject("http://provider-server/user/createUser/"+userId,null, commonResult.class);
        return result;
    }

    @GetMapping("/getUserById/{userId}")
    public commonResult getUserById(@PathVariable Integer userId){
        commonResult result = restTemplate.getForObject("http://provider-server/user/getUserById/"+userId, commonResult.class);
        return result;
    }
}
