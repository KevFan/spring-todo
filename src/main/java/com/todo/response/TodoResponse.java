package com.todo.response;
import com.todo.domain.Todo;
import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * User: kevinfan
 * Date: 2019-06-12
 */
@Data
public class TodoResponse {
    private Todo todo;
    private HttpStatus httpStatus;

    public TodoResponse(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public TodoResponse(Todo todo, HttpStatus httpStatus) {
        this.todo = todo;
        this.httpStatus = httpStatus;
    }
}
