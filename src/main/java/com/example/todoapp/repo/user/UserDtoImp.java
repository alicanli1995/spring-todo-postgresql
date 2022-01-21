package com.example.todoapp.repo.user;


import com.example.todoapp.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class UserDtoImp implements UserDto {

    private final UserJpaDto userJpaDto;

    @Override
    public UserEntity findByMail(String mail) {
        return userJpaDto.findByMail(mail);
    }

    @Override
    public User saveMember(UserEntity userEntity) {
        userJpaDto.save(userEntity);
        return User.convertFromEntity(userEntity);
    }
}
