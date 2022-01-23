package com.example.todoapp.service.todo;

import com.example.todoapp.model.ToDo;
import com.example.todoapp.repo.ToDo.ToDoEntity;

import java.util.List;

public interface ToDoService {
    List<ToDo> findAll();
    List<ToDoEntity> findAllEntities();
    ToDo retrieve(Long id);
    Long save(ToDo todo);
    ToDoEntity saveEntity(ToDoEntity todo);
    void update(ToDoEntity todo);
    void delete(Long id);
}
