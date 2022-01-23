package com.example.todoapp.repo.user;


import com.example.todoapp.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor

public class UserDtoImp implements UserDto {

    private final UserJpaDto userJpaDto;

    @Override
    public UserEntity findByMail(String mail) {
        return userJpaDto.findByMail(mail);
    }

    @Override
    public Long saveMember(UserEntity userEntity) {
        return userJpaDto.save(userEntity).getId();
    }

    @Override
    public UserEntity saveMemberEntities(UserEntity userEntity) {
        return userJpaDto.save(userEntity);
    }

    @Override
    public boolean contains(String mail) {
        Optional<UserEntity> userEntityOptional = Optional.ofNullable(userJpaDto.findByMail(mail));
        return userEntityOptional.isPresent();
    }
}
