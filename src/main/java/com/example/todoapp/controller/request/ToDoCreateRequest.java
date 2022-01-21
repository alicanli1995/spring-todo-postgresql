package com.example.todoapp.controller.request;


import com.example.todoapp.model.ToDo;
import com.example.todoapp.model.User;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.ui.Model;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ToDoCreateRequest implements Serializable {

    private Long memberId;

    @NotBlank
    private String todoItem;

    @NotBlank
    private String shortdescription;

    @NotBlank
    private String status;

    @NotBlank
    private String priority;

    @NotBlank
    private String date;

    private Model model;


    public ToDo convertToToDo() {
        return ToDo.builder()
                .memberId(memberId)
                .todoItem(todoItem)
                .shortdescription(shortdescription)
                .completed(status)
                .priority(priority)
                .date(date)
                .build();
    }

}
