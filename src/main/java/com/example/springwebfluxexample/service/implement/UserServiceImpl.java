package com.example.springwebfluxexample.service.implement;

import com.example.springwebfluxexample.entity.Course;
import com.example.springwebfluxexample.entity.Role;
import com.example.springwebfluxexample.entity.User;
import com.example.springwebfluxexample.model.user.request.UserRegisterRequest;
import com.example.springwebfluxexample.repository.UserRepository;
import com.example.springwebfluxexample.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final ReactiveMongoTemplate reactiveMongoTemplate;

    @Override
    public Mono<User> register(UserRegisterRequest request) {
        User user = mapToUser(request);
        return userRepository.save(user);
    }

    @Override
    public Mono<User> findById(String userId) {
        return userRepository.findById(userId);
    }

    @Override
    public Mono<User> update(User user) {
        return userRepository.save(user);
    }

    @Override
    public Mono<User> updateUserCourseList(String userId, Course course) {
        return findById(userId)
                .flatMap(user -> {
                    Update update = new Update();
                    update.push("courses", course);
                    Criteria criteria = Criteria.where("_id").is(userId);
                    return reactiveMongoTemplate.updateFirst(Query.query(criteria), update, User.class)
                            .thenReturn(user);
                })
                .doOnSuccess(user -> log.info("User: {} course list updated", user.getEmail()));
    }

    @Override
    public Flux<User> getUsers() {
        return userRepository.findAll();
    }

    private User mapToUser(UserRegisterRequest request) {
        return User.builder()
                .email(request.getEmail())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .picture(request.getPicture())
                .role(Objects.nonNull(request.getRole()) ? request.getRole() : Role.LEARNER)
                .build();
    }
}
