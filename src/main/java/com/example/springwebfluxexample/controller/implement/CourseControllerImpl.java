package com.example.springwebfluxexample.controller.implement;

import com.example.springwebfluxexample.controller.CourseController;
import com.example.springwebfluxexample.dto.course.CourseDto;
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
    public ResponseEntity<Mono<Course>> create(Long userId, CreateCourseRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(courseService.create(userId, request));
    }

    @Override
    public ResponseEntity<Flux<CourseDto>> getCourses() {
        return ResponseEntity.ok(courseService.gerCourses());
    }

    @Override
    public ResponseEntity<Mono<Boolean>> join(Long userId, Long courseId) {
        return ResponseEntity.ok(courseService.joinCourse(userId, courseId));
    }
}
