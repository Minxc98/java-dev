package com.demo.webfluxbase.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
@RequestMapping("/api")
public class ReactiveController {

    @GetMapping("/flux")
    public Flux<Integer> fluxExample() {
        return Flux.range(1, 5)
                .delayElements(Duration.ofSeconds(0))
                .doOnNext(System.out::println);
    }

    @GetMapping("/mono/{id}")
    public Mono<ResponseEntity<String>> monoExample(@PathVariable String id) {
        return Mono.just("Item: " + id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }



}
