package com.example.todoapp.model;


import com.example.todoapp.repo.ToDo.ToDoEntity;
import lombok.*;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor

public class ToDo {


    private Long id;

    private Long memberId;

    private String todoItem;

    private String completed;

    private String shortdescription;

    private String date;

    private String priority;

    public static ToDo convertFromEntity(ToDoEntity toDoEntity)
    {
        return ToDo.builder()
                .id(toDoEntity.getId())
                .memberId(toDoEntity.getMemberId())
                .todoItem(toDoEntity.getTodoItem())
                .completed(toDoEntity.getCompleted())
                .shortdescription(toDoEntity.getShortdescription())
                .date(toDoEntity.getDate())
                .priority(toDoEntity.getPriority())
                .build();
    }

    public ToDoEntity convertToTODOEntity() {
        ToDoEntity toDoEntity = new ToDoEntity();
        toDoEntity.setMemberId(getMemberId());
        toDoEntity.setTodoItem(getTodoItem());
        toDoEntity.setCompleted(getCompleted());
        toDoEntity.setShortdescription(getShortdescription());
        toDoEntity.setDate(getDate());
        toDoEntity.setPriority(getPriority());
        return toDoEntity;
    }

}
