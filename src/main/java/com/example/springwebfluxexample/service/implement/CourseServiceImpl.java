package com.example.springwebfluxexample.service.implement;

import com.example.springwebfluxexample.dto.course.CourseDto;
import com.example.springwebfluxexample.entity.Course;
import com.example.springwebfluxexample.entity.UserCourse;
import com.example.springwebfluxexample.mapper.CourseMapper;
import com.example.springwebfluxexample.model.course.request.CreateCourseRequest;
import com.example.springwebfluxexample.repository.CourseRepository;
import com.example.springwebfluxexample.repository.UserCourseRepository;
import com.example.springwebfluxexample.service.CourseService;
import com.example.springwebfluxexample.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    private final UserCourseRepository userCourseRepository;

    private final UserService userService;

    private final CourseMapper courseMapper;

    @Override
    public Mono<Course> create(Long userId, CreateCourseRequest request) {
        return userService.findById(userId)
                .flatMap(user -> courseRepository.save(courseMapper.toEntity(request, userId)))
                .flatMap(course -> userCourseRepository.save(
                                UserCourse.builder()
                                        .userId(userId)
                                        .courseId(course.getId())
                                        .build()
                        )
                        .thenReturn(course))
                .doOnSuccess(course -> log.info("Course {} created", course.getId()));
    }

    @Override
    public Flux<CourseDto> gerCourses() {
        return courseRepository.findAll()
                .flatMap(course -> userCourseRepository.findAll()
                        .filter(userCourse -> userCourse.getCourseId().equals(course.getId()))
                        .map(UserCourse::getUserId)
                        .collectList()
                        .flatMapMany(Flux::just)
                        .flatMap(userService::findAllById)
                        .collectList()
                        .flatMapMany(Flux::just)
                        .flatMap(users -> Flux.just(courseMapper.toDto(course, users))));
    }

    @Override
    public Mono<Boolean> joinCourse(Long userId, Long courseId) {
        return userCourseRepository.save(
                        UserCourse.builder()
                                .userId(userId)
                                .courseId(courseId)
                                .build()
                )
                .thenReturn(Boolean.TRUE);
    }
}
