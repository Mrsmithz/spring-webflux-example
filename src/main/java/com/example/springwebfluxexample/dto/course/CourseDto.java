package com.example.springwebfluxexample.dto.course;

import com.example.springwebfluxexample.entity.Course;
import com.example.springwebfluxexample.entity.Status;
import com.example.springwebfluxexample.entity.User;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;
import java.util.List;

@Getter
public class CourseDto extends Course {

    private final List<User> userList;

    @Builder
    public CourseDto(Long id, String title, String password, String description, String banner, Status status, Long createdBy, Instant createdAt, Instant updatedAt, List<User> userList) {
        super(id, title, password, description, banner, status, createdBy, createdAt, updatedAt);
        this.userList = userList;
    }
}
