package com.example.springwebfluxexample.service;

import com.example.springwebfluxexample.dto.course.CourseDto;
import com.example.springwebfluxexample.entity.Course;
import com.example.springwebfluxexample.model.course.request.CreateCourseRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CourseService {

    Mono<Course> create(Long userId, CreateCourseRequest request);

    Flux<CourseDto> gerCourses();

    Mono<Boolean> joinCourse(Long userId, Long courseId);
}
