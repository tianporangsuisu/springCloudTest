package org.example.feign;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.example.model.commonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "provider-server")
@Component
public interface userFeignClient {

    @GetMapping("/user/getUserById1/{userId}")
//    @CircuitBreaker(name = "backendA",fallbackMethod = "fallBack2")
//    @Bulkhead(name = "backendA",fallbackMethod = "fallBack2")
    @RateLimiter(name = "backendA",fallbackMethod = "fallBack1")
    public commonResult getUserById1(@PathVariable("userId") Integer userId);

    @GetMapping("/user/getUserById2/{userName}")
    @CircuitBreaker(name = "backendA",fallbackMethod = "fallBack2")
    public commonResult getUserById2(@PathVariable("userName") String userName);

    default commonResult fallBack1(Exception e){
        return new commonResult(403,e.toString(),null);
    }


    default commonResult fallBack2(Exception e){
        return new commonResult(403,e.toString(),null);
    }
}
