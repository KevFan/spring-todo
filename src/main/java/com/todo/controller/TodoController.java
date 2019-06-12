package com.todo.controller;

import com.todo.domain.Todo;
import com.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: kevinfan
 * Date: 2019-06-12
 */
@RestController
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @RequestMapping("/api/v1/todo")
    public Iterable<Todo> findAll() {
        return todoRepository.findAll();
    }
}
