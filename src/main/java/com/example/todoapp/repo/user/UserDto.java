package com.example.todoapp.repo.user;


public interface UserDto{
    UserEntity findByMail(String mail);
    Long saveMember(UserEntity userEntity);
    UserEntity saveMemberEntities(UserEntity userEntity);
<<<<<<< HEAD

    boolean contains(String mail);
=======
>>>>>>> 4f3323f26e59ffe7f8a869c55c996292fba5be64
}
