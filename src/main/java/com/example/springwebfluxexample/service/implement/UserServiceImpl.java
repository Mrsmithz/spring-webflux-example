package com.example.springwebfluxexample.service.implement;

import com.example.springwebfluxexample.entity.User;
import com.example.springwebfluxexample.model.user.request.UserRegisterRequest;
import com.example.springwebfluxexample.repository.UserRepository;
import com.example.springwebfluxexample.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public Mono<User> register(UserRegisterRequest request) {
        User user = mapToUser(request);
        return userRepository.save(user);
    }

    @Override
    public Mono<User> findById(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public Flux<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public Flux<User> findAllById(List<Long> userIdList) {
        return userRepository.findAllById(userIdList);
    }

    private User mapToUser(UserRegisterRequest request) {
        return User.builder()
                .email(request.getEmail())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .picture(request.getPicture())
                .role(request.getRole())
                .build();
    }
}
