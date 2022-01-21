package com.example.todoapp.repo.ToDo;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter

@Entity(name = "todo")
@Table(name = "todo")


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



}
