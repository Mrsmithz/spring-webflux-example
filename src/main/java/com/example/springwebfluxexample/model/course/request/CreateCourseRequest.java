package com.example.springwebfluxexample.model.course.request;

import com.example.springwebfluxexample.entity.Status;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateCourseRequest {

    @NotBlank
    @Length(min = 5)
    private String title;

    private String password;

    private String description;

    private String banner;

    private Status status;
}
