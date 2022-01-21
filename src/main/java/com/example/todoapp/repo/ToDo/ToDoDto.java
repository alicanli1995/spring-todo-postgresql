package com.example.todoapp.repo.ToDo;


import java.util.List;

public interface ToDoDto {
    void save(ToDoEntity toDoEntity);
    List<ToDoEntity> findAll();
    ToDoEntity getByIdEntities(Long id);
    List<ToDoEntity> findAllByMemberId(Long memberId);
    void deleteById(Long id);
}
