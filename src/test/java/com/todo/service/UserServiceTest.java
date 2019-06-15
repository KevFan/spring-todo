package com.todo.service;

import com.todo.base.IntegrationTestBase;
import com.todo.domain.User;
import com.todo.dto.UserDTO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
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
        User user = userService.create(userDTO);
        Assert.assertEquals(user.getUsername(), userDTO.getUsername());
        Assert.assertTrue(passwordEncoder.matches(userDTO.getPassword(), user.getPassword()));
    }

    @Test
    public void testLoadUserByUsername() {
        Assert.assertEquals("user", userService.loadUserByUsername("user").getUsername());
    }

    @WithMockUser(username = "user")
    @Test
    public void testGetCurrentUser() {
        Assert.assertEquals("user", userService.getCurrentUser().getUsername());
    }
}