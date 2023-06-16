package org.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class errorController {
    @GetMapping("/error")
    public Mono<String> error(){
        return Mono.just("Service Failed");
    }
}
