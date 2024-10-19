package com.example.springwebfluxexample.service;

import com.example.springwebfluxexample.entity.Course;
import com.example.springwebfluxexample.model.course.request.CreateCourseRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CourseService {

    Mono<Course> create(String userId, CreateCourseRequest request);

    Flux<Course> gerCourses();
}
