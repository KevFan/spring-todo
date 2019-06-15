package com.todo.dto;
import lombok.Data;

/**
 * User: kevinfan
 * Date: 2019-06-12
 */

@Data
public class UserDTO {
    private String username;
    private String password;
    private String confirmPassword;

    public UserDTO() {
    }

    public UserDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
