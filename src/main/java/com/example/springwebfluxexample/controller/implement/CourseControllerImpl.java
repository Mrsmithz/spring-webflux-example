package com.example.springwebfluxexample.controller.implement;

import com.example.springwebfluxexample.controller.CourseController;
import com.example.springwebfluxexample.entity.Course;
import com.example.springwebfluxexample.model.course.request.CreateCourseRequest;
import com.example.springwebfluxexample.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class CourseControllerImpl implements CourseController {

    private final CourseService courseService;

    @Override
    public ResponseEntity<Mono<Course>> create(String userId, CreateCourseRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(courseService.create(userId, request));
    }

    @Override
    public ResponseEntity<Flux<Course>> getCourses() {
        return ResponseEntity.ok(courseService.gerCourses());
    }
}
