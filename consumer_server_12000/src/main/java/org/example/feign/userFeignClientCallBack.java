package org.example.feign;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.example.model.commonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public class userFeignClientCallBack implements userFeignClient{
    @CircuitBreaker(name = "backendA",fallbackMethod = "fallback1")
    public commonResult getUserById1(Integer userId) {
        return null;
    }

    @CircuitBreaker(name = "backendA",fallbackMethod = "fallback2")
    public commonResult getUserById2(String userName) {
        return null;
    }

    public commonResult fallback1(Integer userId,Throwable throwable) {
        return new commonResult(402,"触发了熔断1",null);
    }


    public commonResult fallback2(String userName,Throwable throwable) {
        return new commonResult(402,"触发了熔断2",null);
    }
}
