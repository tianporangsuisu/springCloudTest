package org.example.feign;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.example.model.commonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "provider-server",fallback = userFeignClientCallBack.class)
public interface userFeignClient {

    @GetMapping("/user/getUserById1/{userId}")
    @CircuitBreaker(name = "backendA")
    public commonResult getUserById1(@PathVariable("userId") Integer userId);

    @GetMapping("/user/getUserById2/{userName}")
    @CircuitBreaker(name = "backendA")
    public commonResult getUserById2(@PathVariable("userName") String userName);

    public commonResult fallback1(Integer userId,Throwable throwable);


    public commonResult fallback2(String userName,Throwable throwable);
}
