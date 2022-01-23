package com.example.todoapp.repo.user;

import com.example.todoapp.model.User;


public interface UserDto{
    UserEntity findByMail(String mail);
    Long saveMember(UserEntity userEntity);
    UserEntity saveMemberEntities(UserEntity userEntity);
}
