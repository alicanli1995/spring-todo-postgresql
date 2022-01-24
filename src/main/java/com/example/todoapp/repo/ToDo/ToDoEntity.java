package com.example.todoapp.repo.ToDo;


import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter

@Entity(name = "todo")
@Table(name = "todo")

@EntityListeners(AuditingEntityListener.class)

public class ToDoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long memberId;

    private String todoItem;

    private String completed;

    private String shortdescription;

    private String date;

    private String priority;

    @CreatedDate
    private LocalDateTime createdDate= LocalDateTime.now();



}
