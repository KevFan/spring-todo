package com.todo.controller;

import com.todo.dto.UserDTO;
import com.todo.response.UserResponse;
import com.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: kevinfan
 * Date: 2019-06-12
 */
@RequestMapping(path = "/api/v1/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(path = "", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody UserDTO userDTO) {
        UserResponse userResponse = userService.create(userDTO);
        return ResponseEntity.status(userResponse.getHttpStatus()).body(userResponse.getUser());
    }
}
