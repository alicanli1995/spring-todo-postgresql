package com.example.todoapp.model;


import com.example.todoapp.repo.ToDo.ToDoEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Optional;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor

@ApiModel(value = "ToDo object")
public class ToDo {

    @ApiModelProperty(name = "Unique field for TO-DO class.")
    private Long id;

    @ApiModelProperty(name =  "All to-do tasks has a member.")
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
        toDoEntity.setId(getId());
        toDoEntity.setMemberId(getMemberId());
        toDoEntity.setTodoItem(getTodoItem());
        toDoEntity.setCompleted(getCompleted());
        toDoEntity.setShortdescription(getShortdescription());
        toDoEntity.setDate(getDate());
        toDoEntity.setPriority(getPriority());
        return toDoEntity;
    }

}
