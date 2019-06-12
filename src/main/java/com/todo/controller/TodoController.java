package com.todo.controller;

import com.todo.domain.Todo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * User: kevinfan
 * Date: 2019-06-12
 */
@RestController
public class TodoController {

    @RequestMapping("/api/v1/todo")
    public List<Todo> test() {
        List<Todo> todos = new ArrayList<>();
        todos.add(new Todo(1L, "My todo"));
        return todos;
    }
}
