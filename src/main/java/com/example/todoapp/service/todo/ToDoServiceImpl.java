package com.example.todoapp.service.todo;

import com.example.todoapp.model.ToDo;
import com.example.todoapp.repo.ToDo.ToDoDto;
import com.example.todoapp.repo.ToDo.ToDoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor


public class ToDoServiceImpl implements ToDoService {

    private final ToDoDto toDoDto;


    @Override
    public void save(ToDo todo) {
        ToDoEntity toDoEntity = todo.convertToTODOEntity();
        toDoDto.save(toDoEntity);
    }

    @Override
    public void update(ToDoEntity todo) {
        ToDoEntity toDo = toDoDto.getByIdEntities(todo.getId());
        toDo.setId(todo.getId());
        toDo.setTodoItem(todo.getTodoItem());
        toDo.setPriority(todo.getPriority());
        toDo.setDate(todo.getDate());
        toDo.setShortdescription(todo.getShortdescription());
        toDoDto.save(toDo);
    }


    @Override
    public List<ToDo> findByMemberId(Long memberId) {
        return toDoDto.findAllByMemberId(memberId)
                .stream()
                .map(ToDo::convertFromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ToDo> findAll() {
        return toDoDto.findAll()
                .stream()
                .map(ToDo::convertFromEntity)
                .collect(Collectors.toList());
    }


    @Override
    public void delete(Long id) {
        toDoDto.deleteById(id);
    }

    @Override
    public ToDoEntity findByIdEntities(long id) {
          return toDoDto.getByIdEntities(id);
    }
}
