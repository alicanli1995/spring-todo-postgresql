package com.example.todoapp.service.user;

import com.example.todoapp.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User saveMember(User user);
    Long retrieveByMail(String getMemberName);
}
