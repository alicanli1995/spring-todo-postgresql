package com.example.todoapp.service.user;

import com.example.todoapp.model.User;
import com.example.todoapp.repo.user.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    Long saveMember(User user);
    UserEntity saveEntities(UserEntity user);
    Long retrieveByMail(String getMemberName);
}
