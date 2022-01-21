package com.example.todoapp.repo.role;

import com.example.todoapp.model.enums.ROLE;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor

@Entity(name = "role")
@Table(name = "role")

public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated
    private ROLE roleUser;

    public RoleEntity(ROLE roleUser) {
        super();
        this.roleUser = roleUser;
    }

}
