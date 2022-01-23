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
    public Long save(ToDo todo) {
        ToDoEntity toDoEntity = todo.convertToTODOEntity();
        return toDoDto.save(toDoEntity);
    }
    @Override
    public ToDoEntity saveEntity(ToDoEntity todo) {
        return toDoDto.saveEntities(todo);
    }

    @Override
    public ToDo retrieve(Long id) {
        return toDoDto.retrieveToDo(id);
    }




    @Override
    public void update(ToDoEntity todo) {
        ToDoEntity toDo = toDoDto.getByIdEntities(todo.getId());
        toDo.setId(todo.getId());
        toDo.setCompleted(todo.getCompleted());
        toDo.setMemberId(todo.getMemberId());
        toDo.setTodoItem(todo.getTodoItem());
        toDo.setPriority(todo.getPriority());
        toDo.setDate(todo.getDate());
        toDo.setShortdescription(todo.getShortdescription());
        toDoDto.save(toDo);
    }


    @Override
    public List<ToDo> findAll() {
        return toDoDto.findAll()
                .stream()
                .map(ToDo::convertFromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ToDoEntity> findAllEntities() {
        return toDoDto.findAll();
    }


    @Override
    public void delete(Long id) {
        toDoDto.deleteById(id);
    }


}
