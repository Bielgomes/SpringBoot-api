package com.ifsp.minicurso.todolist.model;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class ToDo {
    @Id
    @GeneratedValue
    private Long id;
    private String description;
    private LocalDateTime startAt;
}
