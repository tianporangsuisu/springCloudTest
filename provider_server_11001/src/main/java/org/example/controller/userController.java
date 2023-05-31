package org.example.controller;

import org.example.model.commonResult;
import org.example.model.user;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

@RestController
@RequestMapping("/user")
public class userController {

    private ArrayList<user> userList = new ArrayList<>();

    @DeleteMapping("/deleteUser/{userId}")
    public void deleteUserById(@PathVariable Integer userId){
        userList.forEach(user -> {
            if (Objects.equals(user.getId(), userId)) {
                userList.remove(user);
                System.out.println(userList);
            }
        });
    }

    @PutMapping("/updateUserById/{userId}/{userName}")
    public void updateUserById(@PathVariable Integer userId,@PathVariable String userName){
        userList.forEach(user -> {
            if (Objects.equals(user.getId(), userId)) {
                user.setName(userName);
            }
        });
    }

    @PostMapping("/createUser/")
    public commonResult<user> createUser(@RequestBody user user){
        System.out.println(user.getName()+user.getId()+user.getAge()+user.getPassword());
        userList.add(user);
        return new commonResult(200,"createSuccess11001",user);
    }

    @GetMapping("/getUserById/{userId}")
    public commonResult<user> getUserById(@PathVariable Integer userId){
        AtomicReference<user> user = new AtomicReference<>(new user());
        userList.forEach(user1 -> {
            if (Objects.equals(user1.getId(), userId)) {
                user.set(user1);
            }
        });
        return new commonResult(200,"getSuccess11001",user);
    }

    @GetMapping("/getUserById1/{userId}")
    public commonResult<user> getUserById1(@PathVariable Integer userId){

        return new commonResult(200, "getSuccess11001", new user(userId, "xh", 20, "123456"));
    }
    @GetMapping("/getUserById2/{userName}")
    public commonResult<user> getUserById2(@PathVariable String userName){
        return new commonResult(200,"getSuccess11001",new user(1111,userName,20,"123456"));
    }
}
