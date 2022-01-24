package com.example.todoapp.repo.ToDo;


import com.example.todoapp.model.ToDo;

import java.util.List;

public interface ToDoDto {
    Long save(ToDoEntity toDoEntity);
    ToDoEntity saveEntities(ToDoEntity toDoEntity);
    List<ToDoEntity> findAll();
    ToDoEntity getByIdEntities(Long id);
    void deleteById(Long id);
    ToDo retrieveToDo(Long l);

}
