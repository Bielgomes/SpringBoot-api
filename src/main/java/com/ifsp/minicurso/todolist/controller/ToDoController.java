package com.ifsp.minicurso.todolist.controller;

import com.ifsp.minicurso.todolist.model.ToDo;
import com.ifsp.minicurso.todolist.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ToDoController {

    @Autowired
    private ToDoRepository toDoRepository;

    @GetMapping("/todo/{id}")
    public ResponseEntity<ToDo> findById(@PathVariable Long id) {
        var toDo = toDoRepository.findById(id);

        if (toDo.isPresent()) {
            return new ResponseEntity<>(toDo.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/todo")
    public ResponseEntity<ToDo> save(@RequestBody  ToDo ToDo) {
        var savedTodo = toDoRepository.save(ToDo);
        return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);
    }
}
