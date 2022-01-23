package com.example.todoapp.model;

import com.example.todoapp.model.enums.ROLE;
import com.example.todoapp.repo.role.RoleEntity;
import com.example.todoapp.repo.user.UserEntity;
import lombok.*;

@Getter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor


public class Role {

    private Long id;

    private ROLE userRole;


    public static Role convertFromEntity(RoleEntity roleEntity)
    {
        return Role.builder()
                .id(roleEntity.getId())
                .userRole(roleEntity.getRoleUser())
                .build();
    }

    public RoleEntity convertToRoleEntity() {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setRoleUser(getUserRole());
        return roleEntity;
    }

}
