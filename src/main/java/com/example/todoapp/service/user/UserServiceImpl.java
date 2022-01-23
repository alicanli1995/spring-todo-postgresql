package com.example.todoapp.service.user;

import com.example.todoapp.model.User;
import com.example.todoapp.model.Role;
import com.example.todoapp.model.enums.ROLE;
import com.example.todoapp.repo.ToDo.ToDoEntity;
import com.example.todoapp.repo.role.RoleEntity;
import com.example.todoapp.repo.user.UserDto;
import com.example.todoapp.repo.user.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor

public class UserServiceImpl implements UserService{

    private final UserDto userDto;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public Long saveMember(User user) {
        UserEntity userEntity = user.convertToUserEntity();
        userEntity.setRoles(Collections.singleton
                ((Role.builder().userRole(ROLE.USER).build().convertToRoleEntity())));
        userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
        return userDto.saveMember(userEntity);
    }

    @Override
    public UserEntity saveEntities(UserEntity user) {
        user.setRoles(Collections.singleton
                ((Role.builder().userRole(ROLE.USER).build().convertToRoleEntity())));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userDto.saveMemberEntities(user);
    }

    @Override
    public Long retrieveByMail(String getMemberName) {
        UserEntity user = userDto.findByMail(getMemberName);
        return user.getId();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userDto.findByMail(username);
        Collection<RoleEntity> role =  user.getRoles();
        Collection<Role> role1 = role.stream().map(Role::convertFromEntity).collect(Collectors.toList());
        if (username == null){
            throw new UsernameNotFoundException("Invalid username or pass.");
        }
        return new org.springframework.security.core.userdetails.User(
                user.getMail(),user.getPassword(),mapRolesToAuthorities(role1));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getUserRole().name()))
                .collect(Collectors.toList());
    }
}
