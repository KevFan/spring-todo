package com.todo.response;

import com.todo.domain.User;
import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * User: kevinfan
 * Date: 2019-06-12
 */
@Data
public class UserResponse {
    private User user;
    private HttpStatus httpStatus;

    public UserResponse(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public UserResponse(User user, HttpStatus httpStatus) {
        this.user = user;
        this.httpStatus = httpStatus;
    }
}
