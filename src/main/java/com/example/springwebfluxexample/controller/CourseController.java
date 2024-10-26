package com.example.springwebfluxexample.controller;

import com.example.springwebfluxexample.dto.course.CourseDto;
import com.example.springwebfluxexample.entity.Course;
import com.example.springwebfluxexample.model.course.request.CreateCourseRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("/course")
public interface CourseController {

    @PostMapping("/create")
    ResponseEntity<Mono<Course>> create(
            @RequestHeader("user-id") Long userId,
            @RequestBody CreateCourseRequest request
    );

    @GetMapping("/all")
    ResponseEntity<Flux<CourseDto>> getCourses();

    @PostMapping("/join/{courseId}")
    ResponseEntity<Mono<Boolean>> join(
            @RequestHeader("user-id") Long userId,
            @PathVariable("courseId") Long courseId
    );
}
