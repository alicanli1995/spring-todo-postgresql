package com.example.todoapp.repo.ToDo;


import com.example.todoapp.model.ToDo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class ToDoDtoImp implements ToDoDto{

    private final ToDoJpaDto toDoJpaDto;

    @Override
    public Long save(ToDoEntity toDoEntity) {
        return toDoJpaDto.save(toDoEntity).getId();
    }

    @Override
    public ToDoEntity saveEntities(ToDoEntity toDoEntity) {
        return toDoJpaDto.save(toDoEntity);
    }

    @Override
    public ToDo retrieveToDo(Long l) {
        Optional<ToDoEntity> toDoEntity = (toDoJpaDto.findById(l));
        return toDoEntity.map(ToDo::convertFromEntity).orElse(null);
    }

    @Override
    public ToDoEntity getByIdEntities(Long id) {
        return toDoJpaDto.getById(id);
    }


    @Override
    public List<ToDoEntity> findAll() {
        return toDoJpaDto.findAll();
    }


    @Override
    public void deleteById(Long id) {
        toDoJpaDto.deleteById(id);
    }




}
