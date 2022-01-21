package com.example.todoapp.repo.ToDo;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ToDoDtoImp implements ToDoDto{

    private final ToDoJpaDto toDoJpaDto;

    @Override
    public void save(ToDoEntity toDoEntity) {
        toDoJpaDto.save(toDoEntity);
    }


    @Override
    public ToDoEntity getByIdEntities(Long id) {
        return toDoJpaDto.getById(id);
    }

    @Override
    public List<ToDoEntity> findAllByMemberId(Long memberId) {
        return toDoJpaDto.findAllByMemberId(memberId);
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
