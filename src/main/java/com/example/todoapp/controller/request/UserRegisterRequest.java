package com.example.todoapp.controller.request;


import com.example.todoapp.model.User;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter


public class UserRegisterRequest {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String mail;

    @NotBlank
    private String password;

    public User convertToMember() {
        return User.builder()
                .firstName(firstName)
                .lastName(lastName)
                .mail(mail)
                .password(password)
                .build();
    }

}
