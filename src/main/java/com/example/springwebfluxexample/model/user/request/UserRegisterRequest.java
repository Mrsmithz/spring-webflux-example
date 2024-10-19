package com.example.springwebfluxexample.model.user.request;

import com.example.springwebfluxexample.entity.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterRequest {

    @NotBlank
    @Email
    private String email;
    private String firstName;
    private String lastName;
    private String picture;
    private Role role;
}
