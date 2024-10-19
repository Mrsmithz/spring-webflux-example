package com.example.springwebfluxexample.service;

import com.example.springwebfluxexample.entity.Course;
import com.example.springwebfluxexample.entity.User;
import com.example.springwebfluxexample.model.user.request.UserRegisterRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

    Mono<User> register(UserRegisterRequest request);

    Mono<User> findById(String userId);

    Mono<User> update(User user);

    Mono<User> updateUserCourseList(String userId, Course course);

    Flux<User> getUsers();
}
