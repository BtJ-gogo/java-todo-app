package com.example.TodoApp.entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String task;
    private Boolean completed;
    private LocalDate dueDate;
    private LocalDate createdAt;
}
