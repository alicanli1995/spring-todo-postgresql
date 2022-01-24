package com.example.todoapp.model;

import com.example.todoapp.model.enums.ROLE;
import com.example.todoapp.repo.role.RoleEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor

@ApiModel(value = "Role object",description = "Role object creating")
public class Role {

    @ApiModelProperty(value = "Unique field for Role class.")
    private Long id;

    @ApiModelProperty(value = "All users has a role. Default value is USER.")
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
