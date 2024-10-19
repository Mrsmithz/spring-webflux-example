package com.example.springwebfluxexample.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.Instant;
import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "course")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Course {

    @Id
    private String id;

    private String title;

    private String password;

    private String description;

    private String banner;

    private Status status;

    @DocumentReference(lazy = true, collection = "user")
    private List<User> users;

    @CreatedDate
    private Instant createdAt;

    @LastModifiedDate
    private Instant updatedAt;

    @DocumentReference(lazy = true, collection = "user")
    private User createdBy;

}
