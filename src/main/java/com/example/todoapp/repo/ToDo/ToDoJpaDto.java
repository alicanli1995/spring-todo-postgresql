package com.example.todoapp.repo.ToDo;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

public interface ToDoJpaDto extends JpaRepository<ToDoEntity,Long> {

    List<ToDoEntity> findAllByMemberId(Long memberId);

    @NotNull Optional<ToDoEntity> findById(Long id);

}
