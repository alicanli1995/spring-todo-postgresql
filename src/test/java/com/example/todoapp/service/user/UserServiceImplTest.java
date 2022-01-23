package com.example.todoapp.service.user;

import com.example.todoapp.repo.user.UserDto;
import com.example.todoapp.repo.user.UserEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    UserServiceImpl userService;

    @Mock
    UserDto userDto;

    @Mock
    BCryptPasswordEncoder passwordEncoder;

    @BeforeEach
    void setUp() {
        userService = new UserServiceImpl(
                userDto,
                passwordEncoder
        );
    }

    @Test
    void when_save_user_should_return_user() {
        UserEntity user = new UserEntity();
        user.setFirstName("Test Name");
        user.setLastName("Test LastName");

        when(userDto.saveMemberEntities(ArgumentMatchers.any(UserEntity.class))).thenReturn(user);

        UserEntity created = userService.saveEntities(user);

        assertThat(created.getFirstName()).isSameAs(user.getFirstName());
        assertThat(created.getLastName()).isSameAs(user.getLastName());

        verify(userDto).saveMemberEntities(user);
    }



}