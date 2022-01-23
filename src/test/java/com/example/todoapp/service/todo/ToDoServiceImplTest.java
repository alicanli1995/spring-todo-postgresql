package com.example.todoapp.service.todo;

import com.example.todoapp.model.ToDo;
import com.example.todoapp.repo.ToDo.ToDoDto;
import com.example.todoapp.repo.ToDo.ToDoEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ToDoServiceImplTest {

    ToDoServiceImpl toDoService;

    @Mock
    ToDoDto toDoDto;

    @BeforeEach
    void setUp() {
        toDoService = new ToDoServiceImpl(
                toDoDto
        );
    }

    @Test
    void should_retrieve_todo(){

        //        Mock
        ToDo mockToDo = ToDo.builder()
                .id(1L)
                .memberId(1L)
                .date("10-10-2022")
                .todoItem("Item")
                .priority("Priority")
                .completed("Yes")
                .shortdescription("Short")
                .build();

        when(toDoDto.retrieveToDo(1L)).thenReturn(mockToDo);
        //        When
        ToDo toDo = toDoService.retrieve(1L);

        //        Then
        assertThat(toDo).isNotNull();
        assertThat(toDo.getId()).isEqualTo(1L);
        assertThat(toDo.getDate()).isEqualTo("10-10-2022");
        assertThat(toDo.getShortdescription()).isEqualTo("Short");
        assertThat(toDo.getPriority()).isEqualTo("Priority");
        assertThat(toDo.getTodoItem()).isEqualTo("Item");

        verifyNoMoreInteractions(toDoDto);
    }

    @Test
    void should_create_todo_task() {
        ToDoEntity toDoEntity = new ToDoEntity();
        toDoEntity.setDate("10-10-2020");

        when(toDoDto.saveEntities(ArgumentMatchers.any(ToDoEntity.class))).thenReturn(toDoEntity);

        ToDoEntity created = toDoService.saveEntity(toDoEntity);

        assertThat(created.getDate()).isSameAs(toDoEntity.getDate());
        verify(toDoDto).saveEntities(toDoEntity);
    }


    @Test
    void should_delete_todo(){

        ToDoEntity toDoEntity = new ToDoEntity();
        toDoEntity.setTodoItem("Test ToDo");
        toDoEntity.setId(1L);

        Mockito.lenient().when(toDoDto.getByIdEntities(toDoEntity.getId())).thenReturn(toDoEntity);

        toDoService.delete(toDoEntity.getId());
        verify(toDoDto).deleteById(toDoEntity.getId());
    }



    @Test
    void should_return_find_all_todo_list() {

        List<ToDoEntity> toDoList = new ArrayList<>();
        toDoList.add(new ToDoEntity());
        toDoList.add(new ToDoEntity());
        toDoList.add(new ToDoEntity());
        toDoList.add(new ToDoEntity());

        given(toDoDto.findAll()).willReturn(toDoList);

        List<ToDoEntity> expected = toDoService.findAllEntities();

        Assertions.assertEquals(expected, toDoList);
        assertThat(expected.size()).isEqualTo(4L);
        verify(toDoDto).findAll();
    }



}