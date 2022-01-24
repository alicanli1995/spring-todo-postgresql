package com.example.todoapp.model;

import com.example.todoapp.repo.role.RoleEntity;
import com.example.todoapp.repo.user.UserEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Collection;

@Getter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor

@ApiModel(value = "User Class")
public class User {

    @ApiModelProperty(name = "Unique field for member class.")
    private Long id;

    private String firstName;

    private String lastName;

    private String mail;

    private String password;

    @ApiModelProperty(value = "this field is created to associate with Role ")
    private Collection<RoleEntity> roles;



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
