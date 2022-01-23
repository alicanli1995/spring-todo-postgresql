package com.example.todoapp.controller.response;

import lombok.*;

@Getter
@Setter
@Builder

public class ToDoCreateResponse {

    private Long todoId;
    public static ToDoCreateResponse convertToMemberResponse(Long id) {
        return ToDoCreateResponse.builder()
                .todoId(id)
                .build();
    }

}
