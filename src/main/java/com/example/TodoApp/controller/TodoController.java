package com.example.TodoApp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import com.example.TodoApp.entity.Todo;
import com.example.TodoApp.repository.TodoRepository;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/tasks")
public class TodoController {
    private final TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    //一覧取得
    @GetMapping()
    public List<Todo> getAllTasks() {
        return todoRepository.findAll();
    }

    //新規作成
    @PostMapping()
    public Todo createTask(@RequestBody Todo todo) {
        return todoRepository.save(todo);
    }

    //詳細取得
    @GetMapping("/{id}")
    public Todo getTask(@PathVariable Long id) {
        return this.todoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found"));
        /*
        if (taskToDeleteOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found");
        }
        */
    }

    //編集
    @PatchMapping("/{id}")
    public Todo updateTask(@PathVariable Long id, @RequestBody Todo todo) {
        Todo taskToUpdate = this.todoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found"));
        /*
        if (taskToUpdateOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found");
        }
        */
        if (todo.getTask() != null) {
            taskToUpdate.setTask(todo.getTask());
        }
        if (todo.getCompleted() != null) {
            taskToUpdate.setCompleted(todo.getCompleted());
        }
        if (todo.getDueDate() != null) {
            taskToUpdate.setDueDate(todo.getDueDate());
        }
        return todoRepository.save(taskToUpdate);
    }

    //削除
    @DeleteMapping("/{id}")
    public Todo deleteTask(@PathVariable("id") Long id) {
        Todo taskToDelete = this.todoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found"));
        /*
        if (taskToDeleteOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found");
        }
        */
        this.todoRepository.delete(taskToDelete);
        return taskToDelete;
    }
}
