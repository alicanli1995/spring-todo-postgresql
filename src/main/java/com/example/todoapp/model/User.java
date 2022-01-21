package com.example.todoapp.model;

import com.example.todoapp.repo.role.RoleEntity;
import com.example.todoapp.repo.user.UserEntity;
import lombok.*;

import java.util.Collection;

@Getter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor

public class User {

    private Long id;

    private String firstName;

    private String lastName;

    private String mail;

    private String password;

    private Collection<RoleEntity> roles;

    public User(String firstName, String lastName, String mail, String password, Collection<RoleEntity> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.password = password;
        this.roles = roles;
    }

    public static User convertFromEntity(UserEntity userEntity)
    {
        return User.builder()
                .id(userEntity.getId())
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .mail(userEntity.getMail())
                .password(userEntity.getPassword())
                .roles(userEntity.getRoles())
                .build();
    }

    public UserEntity convertToUserEntity() {
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(getFirstName());
        userEntity.setLastName(getLastName());
        userEntity.setMail(getMail());
        userEntity.setPassword(getPassword());
        return userEntity;
    }

}
