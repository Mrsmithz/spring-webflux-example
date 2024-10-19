package com.example.springwebfluxexample.repository;

import com.example.springwebfluxexample.entity.Course;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends ReactiveMongoRepository<Course, String> {
}
