package com.todo.controller;

import com.todo.domain.User;
import com.todo.dto.UserDTO;
import com.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public User create(@RequestBody UserDTO userDTO) {
        return userService.create(userDTO);
    }
}
