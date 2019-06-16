package com.todo.service;

import com.todo.base.IntegrationTestBase;
import com.todo.dto.UserDTO;
import com.todo.response.UserResponse;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;

public class UserServiceTest extends IntegrationTestBase {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void testCreate() {
        UserDTO userDTO = new UserDTO("newUser1", "password");
        UserResponse userResponse = userService.create(userDTO);
        Assert.assertEquals(userResponse.getUser().getUsername(), userDTO.getUsername());
        Assert.assertTrue(passwordEncoder.matches(userDTO.getPassword(), userResponse.getUser().getPassword()));
        Assert.assertEquals(userResponse.getHttpStatus(), HttpStatus.CREATED);
    }

    public void testCreateAlreadyExists() {
        UserDTO userDTO = new UserDTO("user", "password");
        UserResponse userResponse = userService.create(userDTO);
        Assert.assertNull(userResponse.getUser());
        Assert.assertEquals(userResponse.getHttpStatus(), HttpStatus.BAD_REQUEST);
    }

    @Test
    public void testLoadUserByUsername() {
        Assert.assertEquals("user", userService.loadUserByUsername("user").getUsername());
    }

    @Test(expected = UsernameNotFoundException.class)
    public void testLoadUserByUsernameNotFound() {
        userService.loadUserByUsername("nonExistentUser");
    }

    @WithMockUser(username = "user")
    @Test
    public void testGetCurrentUser() {
        Assert.assertEquals("user", userService.getCurrentUser().getUsername());
    }
}