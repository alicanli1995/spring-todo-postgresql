package com.example.todoapp.repo.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserJpaDto extends JpaRepository<UserEntity,Long> {
    UserEntity findByMail(String mail);

}
