package com.example.springwebfluxexample.controller.implement;

import com.example.springwebfluxexample.controller.UserController;
import com.example.springwebfluxexample.entity.User;
import com.example.springwebfluxexample.model.user.request.UserRegisterRequest;
import com.example.springwebfluxexample.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    private final UserService userService;

    @Override
    public ResponseEntity<Mono<User>> register(UserRegisterRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.register(request));
    }

    @Override
    public ResponseEntity<Flux<User>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }
}
