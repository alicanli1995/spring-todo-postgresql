package com.example.todoapp.repo.user;


public interface UserDto{
    UserEntity findByMail(String mail);
    Long saveMember(UserEntity userEntity);
    UserEntity saveMemberEntities(UserEntity userEntity);
    boolean contains(String mail);

}
