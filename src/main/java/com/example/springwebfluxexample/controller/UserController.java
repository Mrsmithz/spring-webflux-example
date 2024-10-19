package com.example.springwebfluxexample.controller;

import com.example.springwebfluxexample.entity.User;
import com.example.springwebfluxexample.model.user.request.UserRegisterRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("/user")
public interface UserController {

    @PostMapping("/register")
    ResponseEntity<Mono<User>> register(@RequestBody UserRegisterRequest request);

    @GetMapping("/all")
    ResponseEntity<Flux<User>> getUsers();
}
