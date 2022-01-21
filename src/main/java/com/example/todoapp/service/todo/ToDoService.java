package com.example.todoapp.service.todo;

import com.example.todoapp.model.ToDo;
import com.example.todoapp.repo.ToDo.ToDoEntity;

import java.util.List;

public interface ToDoService {
    List<ToDo> findAll();
    void save(ToDo todo);
    void update(ToDoEntity todo);
    List<ToDo> findByMemberId(Long memberId);
    void delete(Long id);
    ToDoEntity findByIdEntities(long id);
}
