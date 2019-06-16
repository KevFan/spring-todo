package com.todo.service;

import com.todo.domain.Todo;
import com.todo.domain.User;
import com.todo.dto.TodoDTO;
import com.todo.repository.TodoRepository;
import com.todo.response.TodoResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: kevinfan
 * Date: 2019-06-12
 */
@Slf4j
@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    UserService userService;

    public List<Todo> findAll() {
        User user = userService.getCurrentUser();
        log.info("Finding all todo for user " + user.getId());
        return todoRepository.findAllByUser(user);
    }

    public TodoResponse create(TodoDTO todoDTO) {
        User user = userService.getCurrentUser();
        Todo todo = new Todo(todoDTO.getContents(), user);
        todoRepository.save(todo);
        log.info("Saved new todo for user " + user.getId());

        return new TodoResponse(todo, HttpStatus.CREATED);
    }

    public TodoResponse update(Long id, TodoDTO todoDTO) {
        TodoResponse todoResponse;
        User user = userService.getCurrentUser();

        Todo todo = todoRepository.findByIdAndUser(id, user);
        if (todo != null) {
            todo.setContent(todoDTO.getContents());
            todoRepository.save(todo);
            log.info("Update todo " + id  +" for user " + user.getId());

            todoResponse = new TodoResponse(todo, HttpStatus.ACCEPTED);
        } else {
            todoResponse = new TodoResponse(HttpStatus.NOT_FOUND);
            log.warn("Could not find todo " + id  +" for user " + user.getId());
        }

        return todoResponse;
    }

    public HttpStatus delete(Long id) {
        User user = userService.getCurrentUser();
        Todo todo = todoRepository.findByIdAndUser(id, user);

        if (todo == null) {
            log.warn("Todo not found - could not delete todo " + id  + " for user " + user.getId());
            return HttpStatus.NOT_FOUND;
        }

        todoRepository.delete(todo);
        log.info("Deleted todo " + id  +" for user " + user.getId());

        return HttpStatus.OK;
    }

    public List<Todo> search(String search) {
        User user = userService.getCurrentUser();
        log.info("Searching todo for user " + user.getId());

        return todoRepository.findByUserAndAndContentLike(user, search);
    }
}
