package com.example.todoapp.repo.user;


import com.example.todoapp.repo.role.RoleEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;


@Getter
@Setter

@Entity(name = "member")
@Table(name = "member",uniqueConstraints = @UniqueConstraint(columnNames = "mail"))


public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String mail;

    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn
                    (name = "role_id",referencedColumnName = "id"))
    private Collection<RoleEntity> roles;
}
