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
    HttpStatus httpStatus;
    Todo todo;
}
