package com.example.springwebfluxexample.service.implement;

import com.example.springwebfluxexample.entity.Course;
import com.example.springwebfluxexample.entity.Status;
import com.example.springwebfluxexample.entity.User;
import com.example.springwebfluxexample.model.course.request.CreateCourseRequest;
import com.example.springwebfluxexample.repository.CourseRepository;
import com.example.springwebfluxexample.service.CourseService;
import com.example.springwebfluxexample.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    private final UserService userService;

    @Override
    public Mono<Course> create(String userId, CreateCourseRequest request) {
        return userService.findById(userId)
                .flatMap(user -> courseRepository.save(mapToCourse(user, request)))
                .flatMap(course -> userService.updateUserCourseList(userId, course)
                        .thenReturn(course))
                .doOnSuccess(course -> log.info("Course {} created", course.getTitle()));
    }

    @Override
    public Flux<Course> gerCourses() {
        return courseRepository.findAll();
    }

    private Course mapToCourse(User user, CreateCourseRequest request) {
        return Course.builder()
                .title(request.getTitle())
                .password(request.getPassword())
                .description(request.getDescription())
                .banner(request.getBanner())
                .status(Objects.nonNull(request.getStatus()) ? request.getStatus() : Status.ACTIVE)
                .users(List.of(user))
                .createdBy(user)
                .build();
    }
}
