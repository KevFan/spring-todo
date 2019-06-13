package com.todo.service;

import com.todo.domain.Todo;
import com.todo.dto.TodoDTO;
import com.todo.repository.TodoRepository;
import com.todo.response.TodoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: kevinfan
 * Date: 2019-06-12
 */
@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    UserService userService;

    public List<Todo> findAll() {
        return todoRepository.findAllByUser(userService.getCurrentUser());
    }

    public TodoResponse create(TodoDTO todoDTO) {
        Todo todo = new Todo(todoDTO.getContents(), userService.getCurrentUser());
        todoRepository.save(todo);

        return new TodoResponse(todo, HttpStatus.CREATED);
    }

    public TodoResponse update(Long id, TodoDTO todoDTO) {
        TodoResponse todoResponse;

        Todo todo = todoRepository.findByIdAndUser(id, userService.getCurrentUser());
        if (todo != null) {
            todo.setContent(todoDTO.getContents());
            todoRepository.save(todo);

            todoResponse = new TodoResponse(todo, HttpStatus.ACCEPTED);

        } else {
            todoResponse = new TodoResponse(HttpStatus.NOT_FOUND);
        }

        return todoResponse;
    }

    public HttpStatus delete(Long id) {
        Todo todo = todoRepository.findByIdAndUser(id, userService.getCurrentUser());

        if (todo == null) {
            return HttpStatus.NOT_FOUND;
        }

        todoRepository.delete(todo);

        return HttpStatus.OK;
    }

    public List<Todo> search(String search) {
        return todoRepository.findByUserAndAndContentLike(userService.getCurrentUser(), search);
    }
}
