package com.todo.controller;

import com.todo.TodoDTO;
import com.todo.domain.Todo;
import com.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * User: kevinfan
 * Date: 2019-06-12
 */
@RestController
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @RequestMapping(path = "/api/v1/todo", method = RequestMethod.GET)
    public Iterable<Todo> findAll() {
        return todoRepository.findAll();
    }

    @RequestMapping(path = "/api/v1/todo", method = RequestMethod.POST)
    public Todo create(@RequestBody TodoDTO todoDTO) {
        Todo todo = new Todo(todoDTO.getContents());
        todoRepository.save(todo);

        return todo;
    }
}
