package com.todo.controller;

import com.todo.domain.Todo;
import com.todo.dto.TodoDTO;
import com.todo.response.TodoResponse;
import com.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * User: kevinfan
 * Date: 2019-06-12
 */
@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    @RequestMapping(path = "/api/v1/todo", method = RequestMethod.GET)
    public List<Todo> findAll() {
        return todoService.findAll();
    }

    @RequestMapping(path = "/api/v1/todo", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody TodoDTO todoDTO) {
        TodoResponse response = todoService.create(todoDTO);

        return ResponseEntity.status(response.getHttpStatus()).body(response.getTodo());
    }

    @RequestMapping(path = "/api/v1/todo/{id}", method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody TodoDTO todoDTO) {
        TodoResponse response = todoService.update(id, todoDTO);

        return ResponseEntity.status(response.getHttpStatus()).body(response.getTodo());
    }

    @RequestMapping(path = "/api/v1/todo/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("id") Long id) {
        return new ResponseEntity(todoService.delete(id));
    }
}
