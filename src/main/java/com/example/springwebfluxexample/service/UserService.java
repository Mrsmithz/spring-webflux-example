package com.example.springwebfluxexample.service;

import com.example.springwebfluxexample.entity.User;
import com.example.springwebfluxexample.model.user.request.UserRegisterRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface UserService {

    Mono<User> register(UserRegisterRequest request);

    Mono<User> findById(Long userId);

    Flux<User> getUsers();

    Flux<User> findAllById(List<Long> userIdList);
}
