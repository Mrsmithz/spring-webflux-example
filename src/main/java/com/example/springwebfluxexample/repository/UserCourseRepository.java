package com.example.springwebfluxexample.repository;

import com.example.springwebfluxexample.entity.UserCourse;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCourseRepository extends ReactiveCrudRepository<UserCourse, Long> {
}
