package org.example.controller;

import org.example.model.commonResult;
import org.example.model.user;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class userController {

    @GetMapping("/getUserById/{userId}")
    public commonResult<user> getUserById(@PathVariable Integer userId){
        return new commonResult(200,"success",new user(userId,"zs",20,"zs123"));
    }
}
