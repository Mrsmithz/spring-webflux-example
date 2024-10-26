package com.example.springwebfluxexample.mapper;

import com.example.springwebfluxexample.dto.course.CourseDto;
import com.example.springwebfluxexample.entity.Course;
import com.example.springwebfluxexample.entity.User;
import com.example.springwebfluxexample.model.course.request.CreateCourseRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    @Mapping(target = "userList", source = "userList")
    CourseDto toDto(Course course, List<User> userList);

    @Mapping(target = "createdBy", source = "userId")
    Course toEntity(CreateCourseRequest request, Long userId);
}
